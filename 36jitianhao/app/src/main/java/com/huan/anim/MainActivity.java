package com.huan.anim;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener{
	private Fragment lastFragment, currentFragment,mBtn1Fragment,mBtn2Fragment,mBtn3Fragment,mBtn4Fragment,mBtn5Fragment;
	private Button btn1,btn2,btn3,btn4,btn5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		initTab();
	}
	private void initTab() {
		// TODO Auto-generated method stub
		if (mBtn1Fragment == null) {
			mBtn1Fragment = new Btn1Fragment();
		}

		if (!mBtn1Fragment.isAdded()) {
			// 提交事务
			getSupportFragmentManager().beginTransaction().add(R.id.content_layout, mBtn1Fragment).commit();
			// 记录当前Fragment
			currentFragment = mBtn1Fragment;
			lastFragment = mBtn1Fragment;
		}

	}
	
	
	private void clickTab1() {
		if(lastFragment == mBtn2Fragment){
			Futils.HOMEPUSH = 0;
		}else{
			Futils.HOMEPUSH = 1;
		}
		if (lastFragment != mBtn1Fragment) {
			mBtn1Fragment = new Btn1Fragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBtn1Fragment);
		// 记录当前Fragment
		currentFragment = mBtn1Fragment;
		lastFragment = mBtn1Fragment;
	}
	private void clickTab2() {
		if(lastFragment == mBtn3Fragment){
			Futils.HOMEPUSH = 0;
		}else{
			Futils.HOMEPUSH = 1;
		}
		if (lastFragment != mBtn2Fragment) {
			mBtn2Fragment = new Btn2Fragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBtn2Fragment);
		// 记录当前Fragment
		currentFragment = mBtn2Fragment;
		lastFragment = mBtn2Fragment;
	}
	private void clickTab3() {
		if(lastFragment == mBtn4Fragment){
			Futils.HOMEPUSH = 0;
		}else{
			Futils.HOMEPUSH = 1;
		}
		if (lastFragment != mBtn3Fragment) {
			mBtn3Fragment = new Btn3Fragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBtn3Fragment);
		// 记录当前Fragment
		currentFragment = mBtn3Fragment;
		lastFragment = mBtn3Fragment;
	}
	private void clickTab4() {
		if(lastFragment == mBtn3Fragment){
			Futils.HOMEPUSH = 1;
		}else{
			Futils.HOMEPUSH = 0;
		}
		if (lastFragment != mBtn4Fragment) {
			mBtn4Fragment = new Btn4Fragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBtn4Fragment);
		// 记录当前Fragment
		currentFragment = mBtn4Fragment;
		lastFragment = mBtn4Fragment;
	}
	private void clickTab5() {
		if (lastFragment != mBtn5Fragment) {
			mBtn5Fragment = new Btn5Fragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mBtn5Fragment);
		// 记录当前Fragment
		currentFragment = mBtn5Fragment;
		lastFragment = mBtn5Fragment;
	}
	
	
	/**
	 * 添加或者显示碎片
	 * 
	 * @param transaction
	 * @param fragment
	 */
	private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment) {
		if (currentFragment == fragment) {
			return;
		}
		transaction = getSupportFragmentManager().beginTransaction();
		if(Futils.HOMEPUSH == 0){
			transaction.setCustomAnimations(R.anim.push_right_in,
					R.anim.push_right_out,
					R.anim.push_right_in,
					R.anim.push_right_out);
		}else{
			transaction.setCustomAnimations(R.anim.push_left_in,
					R.anim.push_left_out,
					R.anim.push_left_in,
					R.anim.push_left_out);
			
		}
		
		if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
			transaction.hide(currentFragment).add(R.id.content_layout, fragment).commit();
		} else {
			transaction.hide(currentFragment).show(fragment).commit();
		}

		currentFragment = fragment;
		
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn1:
			clickTab1();
			break;
		case R.id.btn2:
			clickTab2();
			break;
		case R.id.btn3:
			clickTab3();
			break;
		case R.id.btn4:
			clickTab4();
			break;
		case R.id.btn5:
			clickTab5();
			break;

		default:
			break;
		}
	}

}
