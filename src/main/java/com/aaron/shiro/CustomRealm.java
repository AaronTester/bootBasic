package com.aaron.shiro;

import com.aaron.pojo.Employee;
import com.aaron.pojo.Permissions;
import com.aaron.pojo.Role;
import com.aaron.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/20
 * 权限添加
 * 身份认证
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取认证通过的用户
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : employee.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permissions permissions: role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionCode());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
            return null;
        }
        //获取用户信息
        String userId = authenticationToken.getPrincipal().toString();
        String pwd = new String((char[]) authenticationToken.getCredentials());
        Employee employee = employeeService.getEmployeeByEmpId(userId);
        if (employee == null) {
            return null;
        }
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                employee,
                employee.getPassword().toString(),
                ByteSource.Util.bytes(userId),
                getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("EMPLOYEE_SESSION", employee);
        session.setAttribute("EMPLOYEE_SESSIONID", employee.getId());
        return simpleAuthenticationInfo;
    }
}
