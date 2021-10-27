package kr.hs.dukyoung.DYApp.jaehoon.request;

import android.os.AsyncTask;

@SuppressWarnings("deprecation")
public class Request extends AsyncTask<Void, Void, Void> {

    IDoInBackground iDoInBackground;
    IOnPostExecute iOnPostExecute;

    public Request(IDoInBackground doInBackground, IOnPostExecute onPostExecute) {
        this.iDoInBackground = doInBackground;
        this.iOnPostExecute = onPostExecute;
    }


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... voids) {
        iDoInBackground.doInBackground();
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        iOnPostExecute.onPostExecute();
    }
}

