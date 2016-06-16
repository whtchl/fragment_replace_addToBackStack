# fragment_replace_addToBackStack

概要： 程序包含一个Activity，三个Fragment和一个snake。点击fragment的button后显示下个一framgment。到第三个fragment点button出现snake。

##解释1

 1.MainActivity 中判断 使用savedInstanceState == null 。
 当你运行之后，不断的旋转屏幕，你会发现每旋转一次屏幕，屏幕上就多了一个FragmentOne的实例，并且后台log会打印出许多套生命周期的回调。

类似：

[html] view plain copy
在CODE上查看代码片派生到我的代码片

    07-20 08:18:46.651: E/FragmentOne(1633): onCreate  
    07-20 08:18:46.651: E/FragmentOne(1633): onCreate  
    07-20 08:18:46.651: E/FragmentOne(1633): onCreate  
    07-20 08:18:46.681: E/FragmentOne(1633): onCreateView  
    07-20 08:18:46.831: E/FragmentOne(1633): onCreateView  
    07-20 08:18:46.891: E/FragmentOne(1633): onCreateView  


这是为什么呢，因为当屏幕发生旋转，Activity发生重新启动，默认的Activity中的Fragment也会跟着Activity重新创建；这样造成当旋转的时候，本身存在的Fragment会重新启动，然后当执行Activity的onCreate时，又会再次实例化一个新的Fragment，这就是出现的原因。

那么如何解决呢：

其实通过检查onCreate的参数Bundle savedInstanceState就可以判断，当前是否发生Activity的重新创建：

默认的savedInstanceState会存储一些数据，包括Fragment的实例：通过打印可以看出：

[java] view plain copy
在CODE上查看代码片派生到我的代码片

    07-20 08:23:12.952: E/FragmentOne(1782): Bundle[{android:fragments=android.app.FragmentManagerState@40d0b7b8, android:viewHierarchyState=Bundle[{android:focusedViewId=2131230721, android:views=android.util.SparseArray@40d0af68}]}]  

所以，我们简单改一下代码，只有在savedInstanceState==null时，才进行创建Fragment实例：
 ```Java
     /*   
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction tx=fm.beginTransaction();
        tx.add(R.id.id_content,new FragmentOne(),"One");
    */
        if(savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction tx = fm.beginTransaction();
            tx.add(R.id.id_content, new FragmentOne(), "ONE");
            tx.commit();
        }
        
  ##解释2
  Fragment One 跳转到Fragment Two 用的是replace（）；Fragment two 跳转到Fragment Three 用hide（）。 
