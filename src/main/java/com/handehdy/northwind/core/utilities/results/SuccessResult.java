package com.handehdy.northwind.core.utilities.results;

public class SuccessResult extends Result {

    public SuccessResult(){   //işlem sonucu başarılı ama geriye bir mesaj vermek istemiyor supere sadece true bilgisi veriyor
        super(true);
    }

    public SuccessResult(String message){
        super(true,message);
    }
}
