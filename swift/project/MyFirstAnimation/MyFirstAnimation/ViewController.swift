//
//  ViewController.swift
//  MyFirstAnimation
//
//  Created by 강병진 on 1/7/25.
//

import UIKit

class ViewController: UIViewController {

    
    
    
    
    
    @IBOutlet weak var boxView: UIView!
    
    
    
    
    @IBAction func moveBox(_ sender: Any) {
        
        UIView.animate(withDuration: 10, animations: {
            self.boxView.frame = CGRect(x: 200, y: 400, width: 200, height: 200)
            self.boxView.backgroundColor = UIColor.yellow
        }) { _ in
            print("애니매이션 종료")
        }
        
        
        
        UIView.animate(withDuration: 10) {
            self.boxView.frame = CGRect(x: 200, y: 400, width: 200, height: 200)
            self.boxView.backgroundColor = UIColor.yellow
        } completion: { _ in
            print("애니매이션 종료")
        }
        
        // Multiple Trailing Closure
        
    }
    
    
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

