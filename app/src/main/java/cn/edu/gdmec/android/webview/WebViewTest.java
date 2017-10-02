package cn.edu.gdmec.android.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTest extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_web_view_test );

        webview=(WebView)findViewById ( R.id.webview );
        webview.getSettings ().setJavaScriptEnabled ( true );
        webview.loadUrl ( "http:www.baidu.com" );
        webview.setWebViewClient ( new MyWebViewClient() );
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack ()){
            webview.goBack ();
            return true;
        }
        return super.onKeyDown ( keyCode,event );
    }
    public class MyWebViewClient extends WebViewClient
    {
        public boolean shouldOverviewUrlLoading(WebView view,String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
}
