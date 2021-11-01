package kr.hs.dukyoung.DYApp.jaehoon.request;

import android.os.AsyncTask;

@SuppressWarnings("deprecation")
public class Request extends AsyncTask<Void, Void, Void> {

    IDoInBackground iDoInBackground = null;
    IOnPostExecute iOnPostExecute = null;
    IOnPreExecute iOnPreExecute = null;
    IOnProgressUpdate iOnProgressUpdate = null;

    public Request(IDoInBackground doInBackground, IOnPostExecute onPostExecute) {
        this.iDoInBackground = doInBackground;
        this.iOnPostExecute = onPostExecute;
    }

    public Request(IDoInBackground doInBackground) {
        this.iDoInBackground = doInBackground;
    }

    public Request(IOnPreExecute onPreExecute, IDoInBackground doInBackground, IOnProgressUpdate onProgressUpdate, IOnPostExecute onPostExecute) {
        this.iOnPreExecute = onPreExecute;
        this.iDoInBackground = doInBackground;
        this.iOnProgressUpdate = onProgressUpdate;
        this.iOnPostExecute = onPostExecute;
    }


    @Override
    protected void onPreExecute() {
        if(iOnPreExecute != null) {
            iOnPreExecute.onPreExecute();
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if(iDoInBackground != null) {
            iDoInBackground.doInBackground();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        if(iOnProgressUpdate != null) {
            iOnProgressUpdate.onProgressUpdate();
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(iOnPostExecute != null){
            iOnPostExecute.onPostExecute();
        }
    }
}

