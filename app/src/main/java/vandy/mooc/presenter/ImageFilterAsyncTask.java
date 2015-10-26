package vandy.mooc.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import vandy.mooc.common.BitmapUtils;

/**
 * Created by igiagante on 22/10/15.
 */
public class ImageFilterAsyncTask extends AsyncTask<Uri, Void, Void> {

    private Context mContext;

    private ImagePresenter mPresenter;

    private Uri url;
    private Uri pathToImage;

    ImageFilterAsyncTask(Context context, ImagePresenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    protected Void doInBackground(Uri... params) {

        url = params[1];
        pathToImage = BitmapUtils.grayScaleFilter(mContext, params[0], params[1]);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mPresenter.onProcessingComplete(url, pathToImage);
    }

}
