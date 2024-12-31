//
//  GameViewController.swift
//  rcpgame
//
//  Created by 강병진 on 12/30/24.
//

import UIKit
import SpriteKit
import GameplayKit

class GameViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if let view = self.view as! SKView? {
            // Load the SKScene from 'GameScene.sks'
            if let scene = SKScene(fileNamed: "GameScene") {
                // Set the scale mode to scale to fit the window
                scene.scaleMode = .aspectFill
                
                // Present the scene
                view.presentScene(scene)
            }
            
            view.ignoresSiblingOrder = true
            
            view.showsFPS = true
            view.showsNodeCount = true
        }
    }
    
    
    
    func randc(){
        com = rcp[Int.random(in:0...2)]
        print(com)
    
        
    
    }
    func pg(){
        if user == com{
            //비겼음을 결과에 출력
            result.text = "비겼습니다."
            
        }else if user == "가위"{
            if com == "보"{
                result.text = "승리!"
                
            }else{
                result.text = "패배!"
            }
            
        }else if user == "바위"{
            if com == "가위"{
                result.text = "승리!"
                
            }else{
                result.text = "패배!"
                
            }
        }else if user == "보"{
            if com == "바위"{
                result.text = "승리!"
            }else{
                result.text = "패배!"
                
            }
        }
    }
    
    
    func urcp(){
        urcptext.text = user
        print(user)
    }
    
    
    func crcp(){
        crcptext.text = com
    }
    
    
    let rcp = ["가위", "바위", "보"]
    var com = " "
    var user = " "
    var toggle = 1
    var done = 0
    
    @IBAction func st(_ sender: Any) {
        randc()
        if toggle == 1{
            crcp()
        }else{
            crcptext.text = " "
        }
        result.text = "가위 바위 보!"
        urcptext.text = " "
        done = 0
        
    }
    
    @IBOutlet weak var result: UILabel!
    
    
    
    @IBAction func usi(_ sender: Any) {
        //가위
        if done == 0{
            user = "가위"
            urcp()
            pg()
            done = 1
            if toggle == 0{
                crcp()
            }
        }
    }
    
    
    
    @IBAction func uro(_ sender: Any) {
        //바위
        if done == 0{
            user = "바위"
            urcp()
            pg()
            done = 1
            if toggle == 0{
                crcp()
            }
        }
    }
    
    
    
    @IBAction func upa(_ sender: Any) {
        //보
        if done == 0{
            user = "보"
            urcp()
            pg()
            done = 1
            if toggle == 0{
                crcp()
            }
        }
    }
    
    
    
    @IBAction func shtoggle(_ sender: Any) {
        if toggle == 1 {
            crcptext.text = " "
            toggle = 0
            
        }else{
            toggle = 1
        }
    }
    
    @IBOutlet weak var urcptext: UILabel!
    
    @IBOutlet weak var crcptext: UILabel!
    
    
    
    
    
    
    override var supportedInterfaceOrientations: UIInterfaceOrientationMask {
        if UIDevice.current.userInterfaceIdiom == .phone {
            return .allButUpsideDown
        } else {
            return .all
        }
    }

    override var prefersStatusBarHidden: Bool {
        return true
    }
}
