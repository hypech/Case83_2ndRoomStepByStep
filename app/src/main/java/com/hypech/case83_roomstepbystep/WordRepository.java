package com.hypech.case83_roomstepbystep;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.hypech.case83_roomstepbystep.async.DeleteAllAsyncTask;
import com.hypech.case83_roomstepbystep.async.DeleteAsynTask;
import com.hypech.case83_roomstepbystep.async.InsertAsyncTask;
import com.hypech.case83_roomstepbystep.async.UpdateAsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWordsLive;

    public WordRepository(Context context){
        WordDatabase wordDatabase = WordDatabase.getDatabase(context.getApplicationContext());
        wordDao = wordDatabase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    void insertWords(Word... words){
        new InsertAsyncTask(wordDao).execute(words);
    }
    void updatWords(Word... words){
        new UpdateAsyncTask(wordDao).execute(words);
    }
    void deleteAllWords(Word... words){
        new DeleteAllAsyncTask(wordDao).execute();
    }
    void deleteWords(Word... words){
        new DeleteAsynTask(wordDao).execute(words);
    }

    public LiveData<List<Word>> getAllWordsLive(){
        return allWordsLive;
    }
}
