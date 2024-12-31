//////////////import UIKit
//////////////import MapKit
//////////////var greeting = "Hello, playground"
//////////////print(greeting)
//////////////dump(greeting)
////////////////print로 뭔지 파악가능 근데 dump가 더 자세한 내용을 파악할 수 있음
////////////
////////////
////////////
////////////var name = "Swift"
////////////print(name)
////////////var thisYear = 2024
////////////var valid = true
////////////
////////////name
////////////print(name)
////////////print(thisYear)
////////////name = "Steve"
////////////// 변수(var) 상수(let) 상수가 안전하고 최적화 잘되기때문에 상수로 만들었다가 필요하면 변수로 수정
//////////
////////////print(g2)
////////////let g1 = 123
////////////
////////////func doSometing(){
////////////    let g1 = 1234
////////////    print(g1)
////////////    if true{
////////////        
////////////    }
////////////}
////////////doSometing()
////////////let g2 = 534223
////////////print(g1)
//////////
//////////
//////////var din:Int = 1
//////////var bin:Double = 1.0
//////////print(Int(Double(din)+bin))
////////
////////
////////let ishappy:Bool = true
//////
//////
////// 
//////let ch: Character = " "
//////print(ch)
////
////let num = 123
////print(type(of: num))
////
////let a: Bool = true
////print(type(of: a))
////
//let a = 1
//var b = 2
//b += a
//print(b)



var user = ""
var com = ""

let rcp = ["rock","paper","scissors"]

user = rcp[Int.random(in: 0...2)]
com = rcp[Int.random(in: 0...2)]

print("유저 :",user,"\n컴퓨터 :",com)

if user == com{
    print("비김")
    
}else if user == "rock"{
    if com == "scissors"{
        print("이김")
        
    }else{
        print( "졌음")
    }
    
}else if user == "paper"{
    if com == "rock"{
        print("이김")
        
    }else{
        print("졌음")
    }
    
}else if user == "scissors"{
    if com == "paper"{
        print("이김")
        
    }else {
        print("졌음")
    }
}
            
