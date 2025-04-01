//
//  ViewController.swift
//  login
//
//  Created by 강병진 on 1/2/25.
//

import UIKit

class ViewController: UIViewController {
    
    // !boolean_expr 값을 토글
    
    // optional! 옵셔널 값을 강제추출
    
    // IUO
    // Implicitly Unwrapped Optinal
    @IBOutlet weak var idfield: UITextField!
    
    @IBOutlet weak var passwordField: UITextField!
    
    func showAlert(messaage: String) {
        let alert = UIAlertController(title: "경고", message: messaage, preferredStyle: .alert)
        
        let okAction = UIAlertAction(title: "확인", style: .default)
        alert.addAction(okAction)
        
        present(alert, animated: true)
    }
    @IBAction func login(_ sender: Any) {
        guard let id = idfield.text, !id.isEmpty else {
            showAlert(messaage: "아이디를 입력해 주세요")
            return
        }
        guard let password = passwordField.text, !password.isEmpty else {
            showAlert(messaage: "비밀번호를 입력해 주세요")
            return
        }
//        if id.count == 0 || password.isEmpty {
//            resultLable.text = "계정을 입력하세요"
//            return
//        }
//        if id == "아이디"{
//            if password == "비밀번호" {
//                resultLable.text = "Login Success"
//            }else{
//                resultLable.text = "비밀번호 오류"
//            }
//        } else {
//            resultLable.text = "Login Fail"
//        }
//        
        resultLable.text = id == "아이디" && password == "비밀번호" ? "Login Success" : "Login Fail"
    }
    
    
    @IBOutlet weak var resultLable: UILabel!
    
    
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        idfield.becomeFirstResponder()
    }

}

