package com.xylink.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by maolizhi on 12/7/2016.
 */
public class Result<T> {

    private boolean success = true;

    /**
     * errorCode represents error code;default value is 200,OK,NOT ERROE
     * */
    private int errorStatus = 200;
    /**
     * When success is true and errorStatus is 200, data represents correct data ,
     * if not,data reoresents error message,the tyoe of data is RestMessage .
     */
    private T data;

    public Result(){}

    public Result(boolean success, int errorStatus, T data) {
        this.success = success;

        this.errorStatus = errorStatus;

        this.data = data;
    }

    @Override
    public String toString(){
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (IOException e) {
            System.out.println("convert Result to Json String error!");
        }
        return null;
    }
    /*{
        // TODO Auto-generated method stub
        Field[] fields=this.getClass().getDeclaredFields();
        StringBuffer strBuf=new StringBuffer();
        strBuf.append(this.getClass().getName());
        strBuf.append("(");
        for(int i=0;i<fields.length;i++)
        {
            Field fd=fields[i];
            strBuf.append(fd.getName()+":");
            try
            {
                strBuf.append(fd.get(this));
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(i!=fields.length-1)
                strBuf.append("|");
        }

        strBuf.append(")");
        return strBuf.toString();
    }*/


    public boolean isSuccess() {
        return success;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
