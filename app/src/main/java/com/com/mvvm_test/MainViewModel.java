package com.com.mvvm_test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    //변화할 수 있는 데이터 , 그냥 live데이터는 불변 데이터에 해당한다.
    private MutableLiveData<Note> note = new MutableLiveData<>();

    public void init(){
        note.setValue(new Note(1,"제목", "내용"));
    }


    // 옵저버로 지켜볼려면 return 해야함.
    public MutableLiveData<Note> getNote(){
        return note;
    }


    public void updateNote(){
        note.setValue(new Note(2,"제목 변경", "내용 변경"));
    }

}
