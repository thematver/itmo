//
//  CSQuizApp.swift
//  CSQuiz
//
//  Created by Матвей Корепанов on 19.06.2023.
//

import SwiftUI

@main
struct CSQuizApp: App {
    
    var quizManager: QuizManager = QuizManager()
    
    var body: some Scene {
        WindowGroup {
            QuizView()
                .environmentObject(quizManager)
        }
    }
}
