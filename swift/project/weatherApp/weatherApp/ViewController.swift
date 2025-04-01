//
//  ViewController.swift
//  weatherApp
//
//  Created by 강병진 on 1/2/25.
//

import UIKit

class ViewController: UIViewController {
    
    
    
    @IBOutlet weak var weatherImageView: UIImageView!
    
    
    @IBOutlet weak var statusLable: UILabel!
    
    
    @IBOutlet weak var temperatureLable: UILabel!
    
    
    
    @IBOutlet weak var recommendLable: UILabel!
    
    
    
    func getWeatherImage(matching weather: String) -> UIImage? {
        switch weather {
        case "맑음":
            return UIImage(named: "sun")
        case "흐림":
            return UIImage(named: "cloud-1")
        case "눈 옴":
            return UIImage(named: "cloud-10")
        case "비 옴":
            return UIImage(named: "cloud-2")
        default:
            return nil
        }
    }
    
    func temperatureToString(temperature: Int) -> String? {
        switch temperature {
        case ..<(-10):
            return "이불 밖은 위험해요"
        case -10 ... 10:
            return "두툼한 패딩을 챙기세요"
        case 11 ... 20:
            return "일교차 조심하세요"
        case 21 ... 30:
            return "여름이 다가오고 있어요"
        case 31...:
            return "xx 여름"
        default:
            return nil
        }
    }
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        let weather = ["맑음", "흐림", "눈 옴", "비 옴"].randomElement() ?? "맑음"
        let temperature = Int.random(in: -20...38)
        
//        if weather == "맑음" {
//            weatherImageView.image = UIImage(named: "sun")
//            
//        }else if weather == "흐림"{
//            weatherImageView.image = UIImage(named: "cloud-1")
//            
//        }else if weather == "눈 옴"{
//            weatherImageView.image = UIImage(named: "cloud-10")
//            
//        }else if weather == "비 옴"{
//            weatherImageView.image = UIImage(named: "cloud-2")
//            
//        }
//
        
        weatherImageView.image = getWeatherImage(matching: weather)
        recommendLable.text = temperatureToString(temperature: temperature)
        statusLable.text = weather
        temperatureLable.text = "\(temperature)º"
    }


}

