JAVA base DigitalConvergence Developer
===
### 목적
**<details><summary>정보</summary>**
> * 디지털 기술을 기반으로 다양한 기기의 융합, 네트워크의 융합, 콘텐츠의 융합을 통해 새로운 형태의 제품이나 융합서비스를 창출하기 위하여 기기, 네트워크, 콘텐츠의 기획, 설계, 제작, 운용 및 시험
> * 컴퓨터 프로그래밍 언어로 각 업무에 맞는 소프트웨어의 기능에 관한 설계, 구현 및 테스트를 수행하고, 사용자에게 배포하며, 버전관리를 통해 제품의 성능을 향상시키고, 서비스를 개선
> * 소프트웨어 구현, 소스 코드 인스펙션
> * 애플리케이션 모듈 구현, 인터페이스 구현
> * UI 설계 산출물과 GUI 디자인 가이드를 바탕으로 UI 구현 표준을 수립하고 UI를 제작
> * 데이터베이스 구현을 위하여 DBMS(Data Base Management System)(DataBase Management Systems) 설치, 데이터베이스 생성, 데이터베이스 오브젝트를 계획, 설계하고 구현
> * 관계형 데이터베이스에서 SQL을 사용하여 응용시스템의 요구기능에 적합한 데이터를 정의하고, 조작하며, 제어

</details>

## 교재
  **<details><summary>정보</summary>**

####
> <img src ="image/javabook.jpg" width="230px">

> **03-16 ~ 05, api포함(Collection(List, Set), Map(Hashing), (String, StringBuffer, StringBuilder))**

> <img src = "image/sql.jpg" width="230px" height = "300px">

> **~**

> <img src = "image/springInAction.png" width="230px">

> **~**

> <img src = "image/webprogramming.jpg" width = "230px">

> **~**

> <img src = "image/jsp,jquery.png" width = "230px">

> **~**

</details>

## 실습

**<details><summary>VendingMachine UML</summary>**

//VendingMachine has-a Beverage
//VendingMachine has-a Money
|      VendingMachine   |
|:------------|
|**멤버변수**|
|- color : String|
|- balance : int|
|- manufacturer : String|
|- money : Money|
|- coin : Money |
|- coke : Beverage|
|- pepsi : Beverage|
|- powerAde : Beverage|
|- sprite : Beverage|
|- cider : Beverage|
|**static 상수**|
|+ D_COKE : int = 1|
|+ D_PEPSI : int = 2|
|+ D_POWERADE : int = 3|
|+ D_SPRITE : int = 4|
|+ D_CIDER : int = 5|
|**메소드**|
|getters / setters|
|+ VendingMachine(color : String, manufacturer : String, coke : Beverage, pepsi : Beverage, powerAde : Beverage, sprite : Beverage, cider : Beverage, money : Money, Coin : Money)
|+ inputMoneySum() : void|
|+ choicePick() : Beverage|
|- returnDrink(beverage : Beverage, balance : int, drink : int) : Beverage
|+ returnMoney() : int|
|- drinkDecrease(drink : int)|
|- soldOut(number : int) : boolean|
|+ toString() : String|

|Beverage|
|:--------|
|**멤버변수**|
|- name : String |
|- count : int|
|- amount : int|
|**메소드**|
|+ Beverage(name : String, amount : int, count : int)|
|+ Beverage(name : String, amount : int)|
|+ getters/setters|
|+ toString() : String|

|Money|
|:------|
|**멤버변수**|
|- tenThousandM : int|
|- fiveThousandM : int|
|- oneThousandM : int|
|- fiveHundredC : int|
|- oneHundredC : int|
|**메소드**|
|+ getters/setters|
|+ moneySum() : int|
|+ coinSum() : int|
|+ toString() : String|

</details>

**<details><summary>StarUnit UML</summary>**

**((interface)) IPowerUpgrade, IMoveUpgrade, IAllAttack, IHeal**

**((abstract)) Unit**

**((abstract)) GroundUnit is-a Unit**

**((abstract)) AirUnit is-a Unit**

**Zealot is-a GroundUnit is-a IMoveUpgrade,IGroundAttack,IPowerUpgrade**

**Mutallisk is-a AirUnit is-a IAllAttack, IPowerUpgrade**

**Medic is-a GroundUnit is-a IHeal**

**((abstract)) Building**

**((abstract)) MovingBuilding is-a Building**

**Command is-a MovingBuilding**

**Nexus is-a Building**

<img src = "image/StarCraftUML2.png">
<img src = "image/StarCraftUML1.png">

</details>

**<details><summary>Design Pattern</summary>**

**UML**

<img src = "image/Star2UML.PNG">
<img src = "image/StarUML.PNG">

</details>

**<details><Summary>Lotto UML</summary>**
<img src = "image/LottoUML.PNG">
</details>

### JFrame Practice

##### Answer1
<img src = "image/JFrame1.JPG">

##### Answer2
<img src = "image/JFrame2.JPG">

##### Answer3
<img src = "image/JFrame3.JPG">

##### Answer4
<img src = "image/JFrame4.JPG">

### Event Practice
..

### Team Project
..
