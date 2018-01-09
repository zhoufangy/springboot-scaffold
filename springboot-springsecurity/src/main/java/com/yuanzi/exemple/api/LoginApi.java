package com.yuanzi.exemple.api;

import com.yuanzi.exemple.model.BaseModel;
import com.yuanzi.exemple.model.User;
import com.yuanzi.exemple.repo.UserRepo;
import com.yuanzi.exemple.util.StatusConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhouFangyuan on 2018/1/8. Information:
 */
@Api(value = "登录接口")
@RestController
@RequestMapping("/")
public class LoginApi {

    final static Logger logger = LoggerFactory.getLogger(LoginApi.class);

    @Autowired
    private UserRepo userRepo;

    @ApiOperation(value = "用户登录校验")
    @RequestMapping(value = "login/checkLogin/{loginName}/{passward}",method = RequestMethod.POST)
    public Object Login(@ApiParam(value = "用户名",defaultValue = "",required = false)
                        @PathVariable String loginName,
                        @ApiParam(value = "密码",defaultValue = "",required = false)
                        @PathVariable String passward){
        logger.info("Login 入参：loginName={},passward={}",loginName,passward);
        try{
            User user = userRepo.findByUsernameAndPassword(loginName,passward);
            if (user!=null){
                return BaseModel.buildSuccess("登录成功");
            }else {
                return BaseModel.buildFail(StatusConstant.LOGIN_FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
            return BaseModel.buildFail(StatusConstant.SYS_ERROR);
        }
    }

}
