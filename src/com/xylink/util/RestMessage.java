package com.xylink.util;

/**
 * <pre>
 * Error response body in case not 200/201:
 * - errorCode         Defined by youmeet, e.g. 1234
 * - userMessage       To app user, e.g. You are unauthorized to use this function
 * - developerMessage  Verbose, plain text of local language about how to fix it, e.g. Client uses deprecated interface &quot;xyz&quot; 
 * - moreInfo          Link to detail context and solution, e.g. http://youmeet/errors/1234
 * </pre>
 */
public class RestMessage
{
   private static final char SEPERATOR = ';';
   private String developerMessage;
   private String userMessage;
   private int errorCode;
   private String moreInfo;

   /**
    * @return the developerMessage
    */
   public String getDeveloperMessage()
   {
      return developerMessage;
   }

   /**
    * @param developerMessage the developerMessage to set
    */
   public void setDeveloperMessage(String developerMessage)
   {
      this.developerMessage = developerMessage;
   }

   /**
    * @return the userMessage
    */
   public String getUserMessage()
   {
      return userMessage;
   }

   /**
    * @param userMessage the userMessage to set
    */
   public void setUserMessage(String userMessage)
   {
      this.userMessage = userMessage;
   }

   /**
    * @return the errorCode
    */
   public int getErrorCode()
   {
      return errorCode;
   }

   /**
    * @param errorCode the errorCode to set
    */
   public void setErrorCode(int errorCode)
   {
      this.errorCode = errorCode;
   }

   /**
    * @return the moreInfo
    */
   public String getMoreInfo()
   {
      return moreInfo;
   }

   /**
    * @param moreInfo the moreInfo to set
    */
   public void setMoreInfo(String moreInfo)
   {
      this.moreInfo = moreInfo;
   }

   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append('{');
      sb.append("errorCode: ").append(errorCode).append(SEPERATOR);
      sb.append("userMessage: ").append(userMessage).append(SEPERATOR);
      sb.append("developerMessage: ").append(developerMessage).append(SEPERATOR);
      sb.append("moreInfo: ").append(moreInfo);
      sb.append('}');
      return sb.toString();
   }
}