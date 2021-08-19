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

