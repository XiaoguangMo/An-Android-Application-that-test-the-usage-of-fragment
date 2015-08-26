package org.crazyit.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	public final static String CALL_RESULT =
			"org.crazyit.app.CALL_RESULT";
	private LinearLayout topContainer;
	private LinearLayout topLeftContainer;

	private LinearLayout topRightContainer;

	private LinearLayout middleContainer;
	private LinearLayout bottomContainer;
	private LinearLayout parentContainer;
	private LinearLayout bottomLeftContainer;
	private LinearLayout bottomRightContainer;
	private LinearLayout mainLayout;
	private RadioGroup rg=null;  
	private Spinner spinner=null;
	private String name=null;	
	private String password=null;	
	private String email=null;	
	private String nation=null;	
	private String sex=null;	

    private String s[]={"中国","美国","英国"};  
	private EditText abc;
	private EditText bcd;
	private EditText bcd2;
	private EditText bcd3;
	private EditText bcd4;
	private EditText bcd5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		radioinit();
		createTopLeftContainer();
		createTopRightContainer();
		createBottomLeftContainer();
		createBottomRightContainer();
		createTopContainer();
		createMiddleContainer();
		createBottomContainer();
		createParentContainer();
		setContentView(parentContainer);
	}

	private void createTopLeftContainer(){
		topLeftContainer = new LinearLayout(this);
		topLeftContainer.setLayoutParams(new LayoutParams(220,600));
		topLeftContainer.setOrientation(LinearLayout.VERTICAL);
		topLeftContainer.setBackgroundColor(Color.BLACK);
		TextView text = new TextView(this);
		topLeftContainer.setPadding(80, 50, 0, 0);
		text.setText("用户名\n\n\n密码\n\n\n确认密码\n\n\n性别\n\n\n来自\n\n\n邮箱地址\n\n\n邮箱通知");
		text.setTextColor(Color.WHITE);
		topLeftContainer.addView(text);
	}
	
	private void createTopRightContainer(){
		topRightContainer = new LinearLayout(this);
		topRightContainer.setLayoutParams(new LayoutParams(220,600));
		topRightContainer.setOrientation(LinearLayout.VERTICAL);
		topRightContainer.setBackgroundColor(Color.BLACK);

		topRightContainer.setPadding(50, 50, 0, 0);
		
		
		
		abc= new EditText(this);
		bcd= new EditText(this);
		bcd2= new EditText(this);
		bcd3= new EditText(this);
		bcd4= new EditText(this);
		bcd5= new EditText(this);
		
		ToggleButton toggle = new ToggleButton(this);
		abc.setBackgroundColor(Color.WHITE);
		bcd.setBackgroundColor(Color.WHITE);
		bcd2.setBackgroundColor(Color.WHITE);
		bcd3.setBackgroundColor(Color.WHITE);
		bcd4.setBackgroundColor(Color.WHITE);
		bcd5.setBackgroundColor(Color.WHITE);
		bcd.setTextColor(Color.BLACK);
		bcd2.setTextColor(Color.BLACK);
		bcd3.setTextColor(Color.BLACK);
		bcd4.setTextColor(Color.BLACK);
		bcd5.setTextColor(Color.BLACK);
		abc.setTextColor(Color.BLACK);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(170, 60);
		lp.setMargins(0, 20, 0, 0);
		bcd.setLayoutParams(lp);
		bcd2.setLayoutParams(lp);
		bcd3.setLayoutParams(lp);
		

		spinner=new Spinner(this);  
        LinearLayout.LayoutParams lp3=new LinearLayout.LayoutParams(-1, -2);  
        spinner.setLayoutParams(lp3);  
        spinner.setPrompt("中国");  
//        spinner
        nation="中国";
        spinner.setBackgroundColor(Color.WHITE);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,s);  
        //设置为下拉式Item格式  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        spinner.setAdapter(aa);  
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        	 
            public void onItemSelected(AdapterView parent, View v,
                            int position, long id) {
                    /*
                     * switch(position){ case 0:{ t.setBackgroundColor(Color.WHITE);
                     * mView.setBackgroundColor(Color.WHITE); break; } case 1:{
                     * t.setBackgroundColor(Color.BLUE);
                     * mView.setBackgroundColor(Color.BLUE); break; } case 2:{
                     * t.setBackgroundColor(Color.RED);
                     * mView.setBackgroundColor(Color.RED); break; } case 3:{
                     * t.setBackgroundColor(Color.BLACK);
                     * mView.setBackgroundColor(Color.BLACK); break; } case 4:{
                     * t.setBackgroundColor(Color.YELLOW);
                     * mView.setBackgroundColor(Color.YELLOW); break; } }
                     */
//                    t.setBackgroundColor(mBackgroundColorCodes[position]);
//                    //mView.setBackgroundColor(mBackgroundColorCodes[position]);
//                    mPreferenceEditor.putInt("Background_color",
//                                    mBackgroundColorCodes[position]);
//                    mPreferenceEditor.commit();
            			 TextView v1 = (TextView)v;
            			 v1.setTextColor(Color.BLACK);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
    });		bcd5.setLayoutParams(lp);
		LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(90, 70);
		lp2.setMargins(0, 10, 70, 0);
		toggle.setLayoutParams(lp2);

		topRightContainer.addView(abc);
		topRightContainer.addView(bcd);
		topRightContainer.addView(bcd2);
		topRightContainer.addView(mainLayout);
		topRightContainer.addView(spinner);
		topRightContainer.addView(bcd5);
		topRightContainer.addView(toggle);
	}
	
	private void createTopContainer(){
		topContainer = new LinearLayout(this);
		topContainer.setLayoutParams(new LayoutParams(480,560));
		topContainer.setOrientation(LinearLayout.HORIZONTAL);
		topContainer.setBackgroundColor(Color.BLACK);
		topContainer.addView(topLeftContainer);
		topContainer.addView(topRightContainer);
	}

	private void createMiddleContainer(){
		middleContainer = new LinearLayout(this);
		middleContainer.setLayoutParams(new LayoutParams(480,80));
		middleContainer.setBackgroundColor(Color.BLACK);
		middleContainer.setGravity(Gravity.CENTER);
		CheckBox agree = new CheckBox(this);
		agree.setText("同意条款");
		agree.setTextColor(Color.WHITE);
		middleContainer.addView(agree);
	}

	private void createBottomLeftContainer(){
		bottomLeftContainer = new LinearLayout(this);
		bottomLeftContainer.setLayoutParams(new LayoutParams(200,60));
		bottomLeftContainer.setOrientation(LinearLayout.HORIZONTAL);
		bottomLeftContainer.setBackgroundColor(Color.BLACK);

		bottomLeftContainer.setGravity(Gravity.RIGHT);
		Button confirm = new Button(this);
		confirm.setText("注册");
		confirm.setTextColor(Color.BLACK);
		confirm.setBackgroundColor(Color.WHITE);
		confirm.setOnClickListener(new OnClickListener()  
        {         
            public void onClick(View v)  
            {  
//                Toast.makeText(getApplicationContext(), "注册失败！",Toast.LENGTH_LONG).show();  ======================================
            	Intent intent = new Intent();
//            	intent.setClass( MainActivity.this,SelectBookActivity.class);
            	intent.setAction(MainActivity.CALL_RESULT);
            	name=abc.getText().toString();
            	password=bcd.getText().toString();
            	email=bcd5.getText().toString();
            	intent.putExtra("name", name);
            	intent.putExtra("password", password);
            	intent.putExtra("email", email);
            	intent.putExtra("nation", nation);
            	intent.putExtra("sex", sex);
            	startActivity(intent);
    
            	MainActivity.this.finish();
            }  
        });  
		bottomLeftContainer.addView(confirm);
	}
	
	
	private void createBottomRightContainer(){
		bottomRightContainer = new LinearLayout(this);
		bottomRightContainer.setLayoutParams(new LayoutParams(200,60));
		bottomRightContainer.setOrientation(LinearLayout.HORIZONTAL);
		bottomRightContainer.setBackgroundColor(Color.BLACK);
		bottomRightContainer.setGravity(Gravity.RIGHT);
		
		Button cancel = new Button(this);
		cancel.setText("取消");
		cancel.setTextColor(Color.BLACK);
		cancel.setBackgroundColor(Color.WHITE);
		cancel.setOnClickListener(new OnClickListener()  
        {         
            public void onClick(View v)  
            {  
            	Toast.makeText(getApplicationContext(), "",Toast.LENGTH_LONG).show();
            	System.exit(0);  
            }  
        });  
		bottomRightContainer.addView(cancel);
	}

	private void createBottomContainer(){
		bottomContainer = new LinearLayout(this);
		bottomContainer.setLayoutParams(new LayoutParams(480,110));
		bottomContainer.setOrientation(LinearLayout.HORIZONTAL);
		bottomContainer.setBackgroundColor(Color.BLACK);
		
		bottomContainer.addView(bottomLeftContainer);
		bottomContainer.addView(bottomRightContainer);
	}
	
	private void createParentContainer(){
		parentContainer = new LinearLayout(this);
		parentContainer.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		parentContainer.setOrientation(LinearLayout.VERTICAL);
		bottomContainer.setBackgroundColor(Color.BLACK);

		parentContainer.addView(topContainer);
		parentContainer.addView(middleContainer);
		parentContainer.addView(bottomContainer);
	}
	
	void radioinit(){  
		mainLayout=new LinearLayout(this);  
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(170,60);  
        mainLayout.setLayoutParams(lp);  
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);  
        rg=new RadioGroup(this);  
        rg.setOrientation(LinearLayout.HORIZONTAL);
        RadioButton rb1=new RadioButton(this);  
        sex="男";
        rb1.setText("男");  
        rb1.setTextColor(Color.WHITE);
        rb1.setId(1);  
        rb1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	sex="男";
            
            }
            });
        RadioButton rb2=new RadioButton(this);  
        rb2.setText("女");  
        rb2.setTextColor(Color.WHITE);
        rb2.setId(2);  
        rb2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	sex="女";
            
            }
            });
        rb1.setChecked(true);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(80, 60);
//		lp3.setMargins(0, 0, 0, 0);
		rb1.setLayoutParams(lp3);
		rb2.setLayoutParams(lp3);
        rg.addView(rb1);  
        rg.addView(rb2);  
        mainLayout.addView(rg);
    }  
      
	class SpinnerSelectedListener implements OnItemSelectedListener{  
		  
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,  
                long arg3) {   
        	
        	nation =s[arg2];
        }  
  
        public void onNothingSelected(AdapterView<?> arg0) {  
        }  
    }  

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
