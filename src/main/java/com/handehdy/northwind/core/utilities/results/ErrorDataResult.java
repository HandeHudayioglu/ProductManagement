package com.handehdy.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data,String message) {   //zaten success yani başarısız onun için true ya da false ı burdan
        super(data, false ,message);             //almaya gerek yok super yardımıyla direkt üst sınıfa false bilgisini geçiyoruz
    }

    public ErrorDataResult(T data){
        super(data,false);    //burda da sadece dışarıdan gelen datayı ve false yu döndürdük
    }

    public ErrorDataResult(String message){   //data bilgisi göndermezsek null olarak dönebilir

        super(null, false ,message);
    }

    public ErrorDataResult(){   //data bilgisi göndermezsek null olarak dönebilir
        super(null, false);
    }



}
