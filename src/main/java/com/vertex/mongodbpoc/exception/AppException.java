package com.vertex.mongodbpoc.exception;

public class AppException extends Exception {
   public AppException(){
       super();
   }
   public AppException(String msg){
       super(msg);
   }
}
