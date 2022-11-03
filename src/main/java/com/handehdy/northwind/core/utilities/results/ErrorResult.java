package com.handehdy.northwind.core.utilities.results;

public class ErrorResult extends Result{

    public ErrorResult(){   //işlem sonucu başarısız ama geriye bir mesaj vermek istemiyor supere sadece true bilgisi veriyor
        super(false);
    }

    public ErrorResult(String message){
        super(false,message);
    }
}
