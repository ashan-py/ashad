//
//  ViewController.swift
//  HelloSwiftProject
//
//  Created by 강병진 on 12/28/24.
//

import UIKit

class ViewController: UIViewController {
    var toggle = 1
    
    
    
    @IBAction func toggle(_ sender: Any) {
    if toggle == 1{
                toggle = 0
            }else{
                toggle = 1
            }
            print(toggle)
    }
    @IBOutlet weak var valuelable: UILabel!
    
    @IBOutlet weak var inputfield: UITextField!
    
    @IBAction func showvalue(_ sender: Any) {
        let name = inputfield.text!
        if toggle == 1{
            valuelable.text = "Hello \(name)"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

