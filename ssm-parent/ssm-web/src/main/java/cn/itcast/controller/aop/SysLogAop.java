package cn.itcast.controller.aop;

import cn.itcast.dao.SysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
public class SysLogAop{


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogDao sysLogDao;


    @Around("execution(* cn.itcast.service.*.*(..))")
    public Object recordLog(ProceedingJoinPoint pjp) throws Throwable {
        SysLog sysLog = new SysLog();

        long startTime = System.currentTimeMillis();
        sysLog.setVisitTime(new Date(startTime));

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLog.setUsername(user.getUsername());
        //访问IP
        String ip = request.getRemoteAddr();
        sysLog.setIp(ip);
        //访问URL
        String uri = request.getRequestURI();
        sysLog.setUrl(uri);
        //目标方法执行时长
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        sysLog.setExecutionTime(endTime - startTime);
        //访问类名+方法名
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        sysLog.setMethod("【类名：】"+className+"，【方法名：】"+methodName);

        //2.保存日志
        sysLogDao.save(sysLog);

        return result;
    }
}
