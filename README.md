# yanolja_test_Android_Ator
### 2021-0814-라이징테스트 1일차
#### *기획서의 변동 사항*
1. 오늘 기획서를 서버 개발자 분과 상의를 하여 작성하였다. 소셜 로그인의 기능은 우선 순위를 뒤에 두라는 개발 리더의 피드백을 받아 기획서에 반영하였다.

#### *서버 개발자와의 회의록*
1. 1주차에는 로그인, 회원과입과 탈퇴 API를 만들어 주신다고 하였다.
2. 나 또한, 2주차에는 많은 API를 엮을 수 있도록, 구현하고자 하는 UI를 1주차 안에 모두 구현해 두겠다고 말씀드렸다.

#### *오늘 한 일*
1. 전체적인 화면 흐름을 구상했다. 각 UI에 맞는 레이아웃과 위젯을 정리하였다.
2. 메인 화면에 BottomNavigationView를 구성하고, BottomNavigation의 자식 Fragment안에 TabLayout을 ViewPager2와 연결시켰다.
3. AppbarLayout을 이용해  스크롤를 내릴 때 Toolbar가 collapsing 되도록 구현했다.
4. 기획서를 기준으로 15%정도 완료된 것 같다.

#### *개발 도중 발생한 이슈*
1. 야놀자 앱의 화면구성이 bottomNavigation안에 tabLayout으로 되어있어 자식 fragment에서 스크롤 될 때, 부모의 toolbar가 collapsing하도록 하는 것이 어려웠다. 결국 NestedScrollView에 설정해 주던 layout_behavior속성을 viewPager2에 설정해 주면 된다는 것을 알아 해결 하였다.

#### *내일 할 일*
1. Main Activity의 BottomNavigation의 자식 중 HomeFragment를 모두 구현해 보고자 한다.

***
### 2021-0815-라이징테스트 2일차
#### *오늘 한 일*
1. tabLayout의 indicator의 길이를 tab의 글자 길이 만큼 되도록 구현했다.
2. Horizontal과 Grid RecyclerView를 이용하여 HomeFragment의 RecommendFragment의 UI를 구현하였다.

#### *개발 도중 발생한 이슈*
1. 화면 구성이 fragment안에 fragment가 담기고 자식 뷰에서 스크롤 또는 스와핑을 진행하면 부모뷰의 fragment가 동작하는 이슈를 발견하였다. 아직 해당 오류는 처리하지 못하였다.
2. 1번과 비슷한 문제로, 자식 fragment의 viewpager를 스크롤 할 시 부모 fragment가 스와핑 되는 현상이다. 아직 처리하지 못하였다.
3. 포커싱과 스크롤을 막는 공부가 많이 필요할 듯 싶다.

#### *내일 할 일*
1. 오늘 발생항 이슈에서 생각보다 너무 많은 시간을 투자해 버렸다. 원래 목표했던 HomeFragment의 RecommendFragment를 구현해보고자 하는 목표를 달성하지 못하였기 때문에 먼저 화면을 다 만들고 포커싱에 대한 이슈를 잡아보려 한다.
2. 이슈가 빠르게 잡힌다면, 로그인과 회원가입 UI를 구현할 계획이다.




***
### 2021-0816-라이징테스트 3일차
#### *오늘 한 일*
1. Home Fragment 완성(2개의 리사이클러 뷰 , 1개의 뷰페이저, 핸들러를 이용한 광고배너 뷰페이저 자동스크롤, Imageview에 어두운 배경을 입혀 하얀 글씨가 잘 보이도록 구성)
2. chip스타일의 tabLayout과 viewPager를 연결함(단, 문제가 있음)
3. 어제의 이슈 해결


#### *개발 도중 발생한 이슈*
1. chip모양의 tabLayout과 viewPager를 연결하는 것까지는 해결하였지만, TagLayout의 TabItem들의 간격을 주는 방법을 아무리 찾아도 못찾았다. 정 안되면, chipGroup과 viewPager를 연결하는 방법으로 시도해보려 한다.


#### *지금까지의 이슈 해결*
1. 자식 view에서 수평 스크롤을 진행할 시 부모의 viewPager가 작동되던 문제가 있었다. 해결한 방법은 자식의 스크롤되는(recycler view 또는 viewPager)의 터치리스너를 이용해 터치가 될 때 부모 viewPager의 isUserEnabled를 false로 돌려 부모의 viewPager가 작동되는 문제를 막아 해결하였다. 정말 많은 시간을 잡아 먹었다..... 이 녀석 때문에 계획이 많이 꼬였다. 그래도 해결해서 다행ㅎ


#### *내일 할 일*
1. 내일은 1차 피드백이 있는 날이다. 따라서, My 야놀자 fragment와 로그인,회원가입 폼을 만들어 로그인,회원가입 API까지 적용해 보려 한다.





***
### 2021-0817-라이징테스트 4일차
#### *오늘 한 일*
1. My야놀자 fragment의 UI를 구성했다.
2. 로그인 UI를 구성했다.



#### *개발 도중 발생한 이슈와 해결 방법*
1. My야놀자 fragment의 UI를 구성하던 중 많은 레이아웃들이 겹치다 보니 그림자를 주는 방법이 헷갈렸다. 그래도 차근차근 효과를 줬다가 뺐다가 하면서 많은 공부가 되었다.

2. My야놀자 fragment를 보면 appBarLayout의 elevation의 효과가 최상단일 경우에는 나타나지 않다가, 최상단이 아니면 elevation효과가 나타난다. 이를 nestedScroll의 onScrollChangeListener로 최상단인지 아닌지를 확인해 주었고, 최상단일 경우 elevation의 효과를 주었다. 사실 elevation를 kotlin으로 적용해도 적용이 되지 않기에 bar모양의 view를 만들어 그림자를 줘보았지만, 위에도 그림자 효과가 생겨 원하던 결과가 아니였다. 이것 저것 만져보던 중 appBarLayout의 translationZ를 높게 줄수록 그림자가 깊어진다는 것을 발견해, kotlin에서 appbar의 translationZ를 = 7f 줌으로써 원하던 효과를 구현했다.

3. 로그인 UI를 작성하던 중 EditText의 hint가 클릭 시 위로 올라가는 효과를 주기 위해 textInputLayout을 사용하였는데 클릭 하기 전 hint의 위치가 밑줄과 많이 떨어져 있는 것이 실제 앱과 달라 이 부분을 고치기 위해 많은 시간이 들었다.... 결국 구글링을 통해 찾았고 boxCollapsedPaddingTop과 paddingTop을 textInputLayout에 적용해 줌으로 써 이를 해결 하였다.

4. textInputEditLayout의 속성 중 app:passwordToggleEnabled를 true로 주면 눈 모양이 생기면서 패스워드(\*로 표시됨)을 일반 텍스트 처럼 볼 수 있는 기능이 있는데, 이는 실제 앱과 달랐다. 실제 앱에서는 처음 부터 해당 토글버튼이 나오지 않고 입력을 하나라도 해야지 출력이 되는데 이 부분을 따라하기 위해 임의의 button을 EditText 옆에 겹쳐 두었고 kotlin코드에서 Visible를 컨트롤 해서 버튼의 출력을 제어하였다. 그리고 InputType을 kotlin에서 변경하는 방법 중 binding.loginEdtPwd.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) 이 코드는 기존 앱과 다른 포맷이 나타나 실제앱과 달랐다. 따라서 binding.loginEdtPwd.transformationMethod = PasswordTransformationMethod.getInstance() 이 코드로 대체하여 해결하였다.


#### *1차 피드백*
1. 퍼블리싱은 좋다고 긍정적인 피드백을 받았다.
2. 나의 욕심이 앞서 디테일과 많은 화면을 만들려는 것이 옳은 것인지 여쭈어 봤고, API를 엮어 기획서에서 세운 우선순위를 먼저 하라는 피드백을 받았다.
3. 2차 피드백까지 기획서에서의 7번 '예약' 까지 구현해 보라는 목표를 정해주셨다. 점점 자신감이 생기는것 같다.



#### *내일 할 일*
1. 로그인의 UI를 만들었기 때문에, 로그인 API와 앱을 연동해 JWT값을 받아서 SharedPreference로 저장하는 부분을 구현해 보려한다.
2. 회원가입 폼을 만들어 회원가입 API와 연동하려 한다.
3. 시간이 된다면, 지역 fragment의 UI를 할 수 있는 만큼 구현해 보려 한다.






***
### 2021-0818-라이징테스트 5일차
#### *오늘 한 일*
1. 회원가입에 필요한 모든 UI를 구성했다.(회원가입 activity 2개, bottomSheetDialog 1개)
2. 로그인 API를 연동해서 response되는 JWT를 sharedPreference에 저장하였다.



#### *개발 도중 발생한 이슈와 해결 방법*
1. MainActivity-HomeFragment에서 TabLayouy의 메뉴를 chip 버튼 처럼 커스텀하여 viewPager와 연결한 부분을 구현했었는데, 메뉴 사이의 마진을 주는 방법을 몰랐다가 오늘 개발 리더의 도움을 받아 해결하였다. 나는 XML코드에서 해결하려고 하였는데 kotlin으로 해결할 수 있었다. 좀 더 다양한 방법으로 해결하는 능력을 키워야겠다.

2. 회원가입 UI를 만들 때 textInputLayout를 이용해서 다양한 입력을 받는다. 문제는 기존의 textInputLayout의 속성만을 이용해서는 실제 앱처럼 만들 수 없었다. 따라서 아이콘들을 visible을 kotlin에서 이용해 실제 앱과 똑같이 작동하도록 구현하였다. 보기에는 금방 만들 수 있을 것 같았는데, 실제로는 그렇지 않았다. 그냥 대충 넘어갈 수도 있었으나, 내 눈에 보인 이상 디테일적인 부분은 놓치기가 싫다.... 



#### *내일 할 일*
1. 내일은 회원가입 폼에 회원가입 API를 연결하고 My야놀자 UI에서 회원의 정보를 조회하는 API를 이용해 로그인 했을 경우의 UI를 구성할 계획이다. (API2개 연동, 그에 따른 추가적인 UI 구성)

2. 1번이 생각보다 빠르게 진행된다면, '지역' fragment의 UI를 제작할 것이다.

3. 만약 2번도 생각보다 빠르게 진행된다면, 네이버 SDK를 이용해 현재 위치를 설정하는 기능을 구현하려 한다.







***
### 2021-0819-라이징테스트 5일차
#### *오늘 한 일*
1. 회원가입API를 이용해 회원가입 기능을 구현했다.
2. JWT토큰의 여부(로그인 유무)에 따라 MY야놀자 화면이 다르게 구성되도록 구현했다.
3. 유저 정보API를 이용해 로그인 시 MY야놀자 화면에서 유저의 정보(포인트, 쿠폰, 닉네임 등등)를 표시
4. 로그아웃 기능 구현



#### *개발 도중 발생한 이슈와 해결 방법*
1. 로그아웃의 기능을 구현할 때, 로그아웃 버튼을 누르면 sharedPreferences에서 토큰을 null로 넣어주었다. 그리고 sharedPreferences에서 JWT를 받아올 때 해당하는 키값이 없다면 null을 default값으로 받아오게 하였다. 이 부분이 문제였다. 나는 로그인의 여부를 확인할 때, isEmpty를 이용해 확인하였는데 프로그램상 null이라는 값 자체를 비어있다고 판단하지 않는다는걸 몰라 이 부분에서 헛탕을 좀 쳤다. 결국 default값을 ""로 설정하였고 isEmpty를 이용해 정상적으로 로그인의 여부를 체크할 수 있었다.


2. 유저정보를 받아오는 API를 보면 URI가 /app/my-yanolja이다. 그런데 나는 언더바를 사용하는 것이 습관이 되어 my_yanolj로 api를 호출하였고 당연히 오류가 났다. 결국 하나하나 다시 뜯어가며 코딩을 했고, 결국 내가 URI를 잘 못 입력했다는걸 발견했다. 작은 실수였지만, 내가 들인 시간은 결코 작지 않았다.....


3. 지역 fragment를 구현해보려 계획을 구상했는데 수직으로 된 메뉴를 어떻게 구성해야할지 몰라 이것저것 검색을 진행했다. 내가 나름 생각한 방법은 tabLayout에 rotation을 주어 수직으로 세워볼까 생각했지만 tabLayout의 특징중 하나인 선택된 메뉴가 가운데로 정렬된다는 점이 실제 앱과 달랐다. 그래서 아직 어떤 위젯을 사용해서 구성할지 고민중이다.



#### *내일 할 일*
1. 지역fragment의 UI를 구성해 보려한다.
2. 지역 fragment에 네이버 SDK를 이용해 지도를 구현해보려한다.






***
### 2021-0820-라이징테스트 6일차
#### *오늘 한 일*
1. 지역 fragment의 UI를 모두 구성했다.
2. 지역 fragment중 지도 검색 부분에 네이버 지도API를 연동했다.




#### *개발 도중 발생한 이슈와 해결 방법*
1. vertical한 메뉴바를 구현하는데 어떤 위젯을 사용할지 몰라 많은 고민을 하다가 원시적이지만, 버튼을 만들어 두고 kotlin으로 코딩하여 메뉴처럼 동작하게 만들었다.



#### *내일 할 일*
1. 네이버 지도 움직임에 따라, 실시간 주소가 출력되도록 구현하려한다.
2. 위치fragment-지도검색fragment의 '위치지정 완료' 버튼을 클릭하면, 해당 좌표를 sharedPreferences에 저장해 마지막에 저장한 좌표를 유지하도록 구현한다.
3. 내주변 fragment의 UI를 구성한다.
