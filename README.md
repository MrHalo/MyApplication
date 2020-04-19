ViewPager+Fragment

    1.首先得有一个FragmentManager，用来管理这些Fragment；
    2.初始化被管理的Fragment，添加到集合中；
    3.创建一个适配器，连接适配器,从而实现适配器的绑定；
    4.初始化ViewPager
    FragmentStatePagerAdapter和FragmentPagerAdapter的使用区别
        FragmentStatePagerAdapter中fragment实例在destroyItem的时候被真正释放，所以FragmentStatePagerAdapter省内存。
        FragmentPagerAdapter中的fragment实例在destroyItem的时候并没有真正释放fragment对象只是detach，所以FragmentPagerAdapter消耗更多的内存，带来的好处就是效率更高一些。
        FragmentPagerAdapter适用于页面比较少的情况，FragmentStatePagerAdapter适用于页面比较多的情况
通常来说自定义控件分为三种：
    1.自定义View：继承View
    2.基于现有组件：继承View的派生类
    3.组合的方式：自定义控件中包含了其他的组件
        过程：/layout下创建xml文件，写入需要组合的控件，然后/values下创建attrs.xml添加属性，并在自定义View代码中实现这些方法，然后就可以在布局中引用，并设置自定义的属性了。