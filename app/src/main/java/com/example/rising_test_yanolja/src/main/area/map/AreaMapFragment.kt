package com.example.rising_test_yanolja.src.main.area.map

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaMapBinding
import com.example.rising_test_yanolja.src.main.area.map.models.AreaMapResponse
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker

class AreaMapFragment : BaseFragment<FragmentAreaMapBinding>(FragmentAreaMapBinding::bind, R.layout.fragment_area_map) , OnMapReadyCallback,AreaMapFragmentView {

    private lateinit var mNaverMap: NaverMap

    private var longitude : Double = 0.0
    private var latitdue : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        longitude = sSharedPreferences.getFloat("longitude",127.06634f).toDouble()
        latitdue = sSharedPreferences.getFloat("latitdue",37.50691f).toDouble()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        NaverMapSdk.getInstance(requireContext()).client = NaverMapSdk.NaverCloudPlatformClient(ApplicationClass.NAVER_MAP_API.CLINET_ID)

        binding.mainAreaMapBtnLocated.setOnClickListener {  }

        val fm = childFragmentManager

        //콜백을 받을 fragment 변수에 선언
        val mapFragment = fm.findFragmentById(R.id.main_area_map_fragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.main_area_map_fragment,it).commit()
            }

        // fragment위젯에 callback리스너를 달아줌줌
       mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {

        //카메라 처음 위치 지정
        var cameraUpdate = CameraUpdate.scrollAndZoomTo(
            LatLng(latitdue,longitude),15.0)

// 사용자의 위치(gps)가 변할 때 발생하는 리스너
//        naverMap.addOnLocationChangeListener {
//            showCustomToast("${it.latitude},${it.longitude}")
//        }

        //카메라 이동할 때 발생하는 리스너
        naverMap.addOnCameraIdleListener {
             longitude = naverMap.cameraPosition.target.longitude
             latitdue = naverMap.cameraPosition.target.latitude
            var coords = "$longitude,$latitdue"
            AreaMapService(this).tryGetAddress(coords)
        }

        naverMap.moveCamera(cameraUpdate)

        //위치 클릭하면 발생하는 리스너
//        naverMap.setOnMapClickListener { pointF, latLng ->
//            showCustomToast("${latLng.latitude}, ${latLng.longitude}")
//        }

        //지도 줌,나침반,축척 안보이게 하는 코드
        naverMap.uiSettings.isScaleBarEnabled=false
        naverMap.uiSettings.isZoomControlEnabled=false
        naverMap.uiSettings.isCompassEnabled=false
    }

    override fun onGetAddressSuccess(response: AreaMapResponse) {
        if(response.status.name=="ok"){
            var name1 = response.results[0].region.area1.name
            var name2 = response.results[0].region.area2.name
            var name3 = response.results[0].region.area3.name
            var name4 = response.results[0].region.area4.name

            binding.mainAreaTxAddress.text="$name1 $name2 $name3 $name4"

        }else{
            binding.mainAreaTxAddress.text="여기가 어디인지 모르겠어요"
        }
    }

    override fun onGetAddressFailure(message: String) {
        Log.d("TAG",message)
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        var editor = sSharedPreferences.edit()
        editor.putFloat("latitude",latitdue.toFloat())
        editor.putFloat("longitude",longitude.toFloat())
        editor.apply()
    }
}