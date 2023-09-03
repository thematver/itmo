//
//  QuizManage.swift
//  CSQuiz
//
//  Created by Матвей Корепанов on 19.06.2023.
//

import Foundation
import UIKit

struct Answer: Identifiable, Hashable {
    let id = UUID()
    let name: String
}

class QuizManager: ObservableObject {
    @Published var currentQuestionIndex: Int = 0
    @Published var selectedAnswers = Set<Answer>()
    @Published var questions = [Question]()
    @Published var isIncorrectState: Bool = false
    @Published var currentQuestion: Question?
    @Published var currentAnswers: [Answer] = [Answer]()
    
    @Published var askedQuestion: String = "" {
        didSet {
           changeQuestion(Int(askedQuestion ?? "0") ?? 0)
        }
    }
    
    var fg = UINotificationFeedbackGenerator()
    
    init(currentQuestionIndex: Int = 0) {
        self.currentQuestionIndex = currentQuestionIndex
        questions = loadJson(filename: "questions") ?? []
        self.currentQuestion = questions[currentQuestionIndex]
        wrapAnswers()
    }
    
    init() {
        self.currentQuestionIndex = getCurrentQuestionIndex()
 
        questions = loadJson(filename: "questions") ?? []
        self.currentQuestion = questions[currentQuestionIndex]
        wrapAnswers()
    }
    
    func loadJson(filename fileName: String) -> [Question]? {
        if let url = Bundle.main.url(forResource: fileName, withExtension: "json") {
            do {
                let data = try Data(contentsOf: url)
                let decoder = JSONDecoder()
                let jsonData = try decoder.decode([Question].self, from: data)
                return jsonData
            } catch {
                print("error:\(error)")
            }
        }
        return nil
    }
    
    func saveCurrentQuestionIndex() {
        UserDefaults.standard.set(currentQuestionIndex, forKey: "CurrentQuestion")
        UserDefaults.standard.synchronize()
    }
    
    func getCurrentQuestionIndex() -> Int {
        UserDefaults.standard.integer(forKey: "CurrentQuestion")
    }
    
    func wrapAnswers() { 
  
        currentAnswers = currentQuestion!.answers.map({ answer in
            Answer(name: answer)
        }).shuffled()
    }
    
    func correctAnswers() -> Set<String> {
        Set<String>(currentQuestion!.rightAnswers)
    }
    
    func isSelected(_ answer: Answer) -> Bool {
        selectedAnswers.contains(answer)
    }
    
    func isRight(_ answer: Answer) -> Bool {
        correctAnswers().contains(answer.name)
    }
    
    func select(_ answer: Answer) {
        if selectedAnswers.contains(answer) {
            selectedAnswers.remove(answer)
        } else {
            selectedAnswers.insert(answer)
        }
    }
    
    func changeQuestion(_ number: Int) {
        if questions.isEmpty { return }
        if number < 0 && number >= 1200 {
            return
        }
        currentQuestionIndex = number
        self.currentQuestion = questions[currentQuestionIndex]
        selectedAnswers = Set<Answer>()
        wrapAnswers()
    }
    
    func next() {
            if Set<String>(selectedAnswers.map({$0.name})).containsSameElements(as: correctAnswers()) {
                currentQuestionIndex += 1
                currentQuestion = questions[currentQuestionIndex]
                wrapAnswers()
                selectedAnswers = Set<Answer>()
                fg.notificationOccurred(.success)
                saveCurrentQuestionIndex()
            } else {
                if isIncorrectState {
                    selectedAnswers = Set<Answer>()
                    isIncorrectState = false
                    currentAnswers.shuffle()
                } else {
                    isIncorrectState = true
                    fg.notificationOccurred(.error)
                }
            }
    }
    

    
}


extension Set where Element: Comparable {
    func containsSameElements(as other: Set<Element>) -> Bool {
        return self.count == other.count && self.sorted() == other.sorted()
    }
}
