package com.handehdy.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{


    public SuccessDataResult(T data,String message) {   //zaten success yani başarılı onun için true ya da false ı burdan
        super(data, true ,message);             //almaya gerek yok super yardımıyla direkt üst sınıfa true bilgisini geçiyoruz
    }

    public SuccessDataResult(T data){
        super(data,true);    //burda da sadece dışarıdan gelen datayı ve true yu döndürdük
    }

    public SuccessDataResult(String message){   //data bilgisi göndermezsek null olarak dönebilir
        super(null, true ,message);
    }

    public SuccessDataResult(){   //data bilgisi göndermezsek null olarak dönebilir
        super(null, true);
    }


}
