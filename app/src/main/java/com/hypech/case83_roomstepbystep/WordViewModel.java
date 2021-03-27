package com.hypech.case83_roomstepbystep;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/* 但是ViewModel 的职责是管理界面的数据，数据的获取不应该属于ViewModel，
 * 如插入、修改数据等。
 * 我们应该创建仓库类，来实现对数据的直接操作。
 */

public class WordViewModel extends AndroidViewModel {
    private WordDao wordDao;
    private WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }
    void insertWords(Word... words) {
        wordRepository.insertWords(words);
    }
    void updatWords(Word... words){
        wordRepository.updatWords(words);
    }
    void deleteAllWords(Word... words){
        wordRepository.deleteAllWords();
    }
    void deleteWords(Word... words){
        wordRepository.deleteWords(words);
    }

    LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }
}
