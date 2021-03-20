package com.tac.listeners;

import com.tac.utility.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = ExcelUtils.getTestExecutionDetails();
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++){
            for(int j=0;j<list.size();j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("MethodName"))){
                    if(list.get(j).get("Execution Flag").equalsIgnoreCase("yes")){
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Execution Times")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
                        result.add(methods.get(i));
                    }
                }
            }
        }


        return result;
    }
}
