//
//  ViewController.swift
//  MyFirstCalculator
//
//  Created by 강병진 on 1/1/25.
//

import UIKit

class ViewController: UIViewController {
    var selectedOperator: Operator?
    
    @IBOutlet weak var firstOperndfield: UITextField!
    
    @IBAction func selectOperator(_ sender: Any) {
        let actionSheet = UIAlertController(title: nil, message: nil, preferredStyle: .actionSheet)
        
        
        let plusAction = UIAlertAction(title: "+(더하기)", style: .default) { _ in
            self.operatorButton.setTitle("+", for: .normal)
            self.selectedOperator = .plus
        }
        
        actionSheet.addAction(plusAction)
        
        let minusAction = UIAlertAction(title: "-(빼기)", style: .default) { _ in
            self.operatorButton.setTitle("-", for: .normal)
            self.selectedOperator = .minus
        }
        actionSheet.addAction(minusAction)
        
        let multiplyAction = UIAlertAction(title: "x(곱하기)", style: .default) { _ in
            self.operatorButton.setTitle( "x", for: .normal)
            self.selectedOperator = .multiply
        }
        actionSheet.addAction(multiplyAction)
        
        
        
        let divideAction = UIAlertAction(title: "÷(나누기)", style: .default) { _ in
            self.operatorButton.setTitle( "÷", for: .normal)
            self.selectedOperator = .divide
        }
        actionSheet.addAction(divideAction)
        
        present(actionSheet, animated: true)
        
    }
        
        
          
    @IBOutlet weak var operatorButton: UIButton!
    
    
    @IBOutlet weak var secondOperandField: UITextField!
    
    
    
    @IBOutlet weak var resultLable: UILabel!
    
    
    @IBAction func calculate(_ sender: Any) {
        func emergency(message: String, title: String = "경고") {
            let alert = UIAlertController(title: "경고", message: message, preferredStyle: .alert)
            
            let okAction = UIAlertAction(title: "확인", style: .default)
            alert.addAction(okAction)
            present(alert, animated: true)
        }
        guard let text = firstOperndfield.text, let a = Int(text) else {
            firstOperndfield.becomeFirstResponder()
            emergency(message: "값을 입력해 주세요")
            return
        }
        guard let text = secondOperandField.text, let b = Int(text) else {
            secondOperandField.becomeFirstResponder()
            emergency(message: "값을 입력해 주세요")
            return
        }
        guard var op = selectedOperator else {
            emergency(message: "연산자를 입력해 주세요")
            
            return
        }
        
        var result: Int? = nil
        switch op {
        case .plus:
            result = a + b
        case .minus:
            result = a - b
        case .multiply:
            result = a * b
        case .divide:
            if b == 0{
                resultLable.text = "0으로 못 나눔"
            }else{
                if a % b != 0{
                    resultLable.text = "\(Double(a) / Double(b))"
                }else{
                    result = (a / b)
                }
            }
        }
        guard let result else { return }
        
        resultLable.text = "\(result)"
//        }else if op == "+" {
//            let result = a + b
//            resultLable.text = "\(result)"
//            
//        }else if op == "-" {
//            let result = a - b
//            resultLable.text = "\(result)"
//            
//        }else if op == "*" {
//            let result = a * b
//            resultLable.text = "\(result)"
//            
//        }else if op == "/" {
//            if b == 0{
//                resultLable.text = "0으로 못 나눔"
//            }else{
//                if a % b != 0{
//                    resultLable.text = "\(Double(a) / Double(b))"
//                }else{
//                    resultLable.text = "\(a / b)"
//                }
//            }
//        }
//
        
        
        
        
        if firstOperndfield.isFirstResponder{
            firstOperndfield.resignFirstResponder()
        }else{
            secondOperandField.resignFirstResponder()
        }
        
        
        
        
        
    }
    
    
    
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        firstOperndfield.becomeFirstResponder()
    }


}

