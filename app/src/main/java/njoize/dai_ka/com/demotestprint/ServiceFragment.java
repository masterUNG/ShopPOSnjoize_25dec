package njoize.dai_ka.com.demotestprint;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyConstant myConstant = new MyConstant();

    private int postionAnInt = 1;

    public static ServiceFragment serviceInstant(int positionInt) {
        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Position", positionInt);
        serviceFragment.setArguments(bundle);
        return serviceFragment;
    }


    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        postionAnInt = getArguments().getInt("Position", 1);

//        Create TabLayout
        createTabLayout();

//        Create ViewPager
        createViewPager();




    } // Main Medthod

    private void createViewPager() {
        viewPager = getView().findViewById(R.id.viewPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setCurrentItem(postionAnInt);

    }

    private void createTabLayout() {
        tabLayout = getView().findViewById(R.id.tabLayout);
        String[] strings = myConstant.getTitleTabStrings();
        int[] iconInts = myConstant.getIconBillTitleInts();
        for (int i=0; i<strings.length; i+=1) {
            tabLayout.addTab(tabLayout.newTab().setText(strings[i]).setIcon(iconInts[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false);
    }

} // Main Class
