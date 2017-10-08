package com.hmh.core;

import com.hmh.common.BFConstant;
import com.hmh.common.Logger;
import com.hmh.entity.User;
import com.hmh.service.UserService;
import com.hmh.service.impl.UserServiceImpl;
import com.hmh.util.BeanUtil;
import com.hmh.util.ProjectConfigUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public class AddUserJob extends QuartzJobBean {
    private static Logger logger = Logger.getLogger(AddUserJob.class);
    /**
     *
     * 每天具体Job
     *
     * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        try {
            Properties properties = ProjectConfigUtil.getConfig();
            if(BFConstant.TRUE.equals(properties.get("saveUserJob"))){
                UserService userService = BeanUtil.getBean("userService", UserServiceImpl.class);
                logger.info("start calling saveUser.");
                User user = new User();
                user.setAddress(new Random().nextInt(10000) + "");
                user.setName(UUID.randomUUID().toString());
                userService.saveUser(user);
                logger.info("end up calling saveUser.");
            }
        }
        catch (Exception e)
        {
            logger.error(e.toString(), e);
        }

    }
}
