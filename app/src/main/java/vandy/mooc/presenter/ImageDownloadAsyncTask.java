package vandy.mooc.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import vandy.mooc.common.DownloadUtils;

/**
 * Created by igiagante on 22/10/15.
 */
public class ImageDownloadAsyncTask extends AsyncTask<String, Runnable, Uri> {

    private ImageFilterAsyncTask mImageFilterAsyncTask;
    private Context mContext;
    private Uri mDirectoryPathname;

    ImageDownloadAsyncTask(Context context, ImageFilterAsyncTask imageFilterAsyncTask, Uri directoryPathname) {
        mContext = context;
        mImageFilterAsyncTask = imageFilterAsyncTask;
        mDirectoryPathname = directoryPathname;
    }

    @Override
    protected Uri doInBackground(String... params) {

        Uri url = Uri.parse(params[0]);
        Uri directoryPathname = Uri.parse(params[1]);

        Uri uri = DownloadUtils.downloadImage(mContext, url, directoryPathname);

        return uri;
    }

    @Override
    protected void onPostExecute(Uri uri) {
        mImageFilterAsyncTask.executeOnExecutor(THREAD_POOL_EXECUTOR, uri, mDirectoryPathname);
    }
}
