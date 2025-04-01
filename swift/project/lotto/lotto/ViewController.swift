//
//  ViewController.swift
//  lotto
//
//  Created by 강병진 on 1/3/25.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var number1Label: UILabel!
    @IBOutlet weak var number2Label: UILabel!
    @IBOutlet weak var number3Label: UILabel!
    @IBOutlet weak var number4Label: UILabel!
    @IBOutlet weak var number5Label: UILabel!
    @IBOutlet weak var number6Label: UILabel!
    @IBOutlet weak var number7Label: UILabel!
    
    
    @IBOutlet var labels: [UILabel]!
    
    
    func getColors(from number: Int?) -> (backgroundColor: UIColor, textColor: UIColor) {
        guard let number else { return (UIColor.purple, UIColor.white) }
        
        switch number {
        case 1 ... 10:
            return (UIColor.yellow, UIColor.black)
        case 11 ... 20:
            return (UIColor.blue, UIColor.white)
        case 21 ... 30:
            return (UIColor.red, UIColor.white)
        case 31 ... 40:
            return (UIColor.gray, UIColor.white)
        case 41 ... 45:
            return (UIColor.green, UIColor.black)
        default:
            return (UIColor.purple, UIColor.white)
        }
    }

    @IBAction func newLottonumber(_ sender: Any) {
        var ofcLotto: [Int] = []
        
        var ofcBonus: [Int] = []
        while ofcLotto.count < 6 {
            
            let rndnum = Int.random(in: 1...45)
            
            if !ofcLotto.contains(rndnum) {
                
                ofcLotto.append(rndnum)
            }
        }
        ofcLotto.sort()
        let labelss:  [UILabel] = [number1Label!, number2Label!, number3Label!, number4Label!, number5Label!, number6Label!]
        
        for (index, label) in labelss.enumerated() {
            
            label.backgroundColor = getColors(from: ofcLotto[index]).backgroundColor
            label.textColor = getColors(from: ofcLotto[index]).textColor
        }
        
        
        while ofcBonus.count < 1 {
            let bonusNum = Int.random(in: 1...45)
            if !ofcLotto.contains(bonusNum) {
                ofcBonus.append(bonusNum)
            }
            
        }
        let colors = getColors(from: nil)
        number7Label.backgroundColor = colors.backgroundColor
        number7Label.textColor = colors.textColor
        
        number1Label.text = "\(ofcLotto[0])"
        number2Label.text = "\(ofcLotto[1])"
        number3Label.text = "\(ofcLotto[2])"
        number4Label.text = "\(ofcLotto[3])"
        number5Label.text = "\(ofcLotto[4])"
        number6Label.text = "\(ofcLotto[5])"
        number7Label.text = "\(ofcBonus[0])"
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillTransition(to size: CGSize, with coordinator: any UIViewControllerTransitionCoordinator) {
        super.viewWillTransition(to: size, with: coordinator)
        
        coordinator.animate { _ in
            for label in self.labels {
                label.layer.cornerRadius = self.number1Label.bounds.width / 2
                label.clipsToBounds = true
            }
            
            
        }
    }
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        number1Label.layer.cornerRadius = number1Label.bounds.width / 2
        number1Label.clipsToBounds = true
        
        number2Label.layer.cornerRadius = number2Label.bounds.width / 2
        number2Label.clipsToBounds = true
        
        number3Label.layer.cornerRadius = number3Label.bounds.width / 2
        number3Label.clipsToBounds = true
        
        number4Label.layer.cornerRadius = number4Label.bounds.width / 2
        number4Label.clipsToBounds = true
        
        number5Label.layer.cornerRadius = number5Label.bounds.width / 2
        number5Label.clipsToBounds = true
        
        number6Label.layer.cornerRadius = number6Label.bounds.width / 2
        number6Label.clipsToBounds = true
        
        number7Label.layer.cornerRadius = number7Label.bounds.width / 2
        number7Label.clipsToBounds = true
    }

}

