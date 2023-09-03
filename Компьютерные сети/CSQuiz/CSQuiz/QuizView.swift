//
//  QuizView.swift
//  CSQuiz
//
//  Created by Матвей Корепанов on 19.06.2023.
//

import Foundation
import SwiftUI

struct QuizView: View {
    @EnvironmentObject var quizManager: QuizManager
    @State var presentAlert: Bool = false
    init() {
        UILabel.appearance(whenContainedInInstancesOf: [UINavigationBar.self]).adjustsFontSizeToFitWidth = true
        }
    
    func randomErrorString() -> String {
        return [
        "Ужасно.",
        "Тебе не сдать экзамен.",
        "Ты обречен на поражение.",
        "Ответ Артем Дыбов подсказал?",
        "Ну ты и лох!",
        "Уже поздоровался с допсой?",
        "Толя Лаптев бы ответил на этот вопрос.",
        "Может, лучше вздернешься на суку?",
        "Алиев недоволен.",
        "Невероятная тупость.",
        "И... это неправильный ответ!",
        "Глупость!",
        "И что это мы высрали?",
        "Дебилизм не лечится.",
        "Ваша оценка: 47. Хромосом.",
        "Ваш уровень мысли: либерал.",
        "Так еще никто не ошибался!",
        "Вот это да!",
        "Включай мозг.",
        "Жалко на это тратить ЦПУ."
        ].randomElement()!
    }
    var body: some View {
        if quizManager.questions.isEmpty {
            ProgressView()
        } else {
            NavigationView {
                VStack(alignment: .leading) {
                    
                    if let image = quizManager.questions[quizManager.currentQuestionIndex].image {
                        Image(image)
                            .resizable()
                            .scaledToFit()
                    }
                    
                    Text(quizManager.questions[quizManager.currentQuestionIndex].title)
                        .padding(.bottom)
                    
                    ScrollView {
                        VStack(alignment: .leading, spacing: 20.0) {
                            ForEach(quizManager.currentAnswers, id: \.id) { answer in
                                if quizManager.isIncorrectState {
                                    
                                    Text(answer.name)
                                        .foregroundColor(
                                            quizManager.isRight(answer) ? Color.green : Color.red
                                        )
                                        .fixedSize(horizontal: false, vertical: true)
                                    
                                } else {
                                    
                                    
                                    HStack {
                                        ZStack {
                                           
                                            Circle()
                                                .strokeBorder()
                                                .frame(width: 24, height: 24)
                                                .background(Color.white)
                                            
                                            if quizManager.isSelected(answer) {
                                                Circle()
                                                    .frame(width: 16, height: 16)
                                            }
                                                
                                            
                                        }
                                        Text( answer.name)
                                            .fontWeight(quizManager.selectedAnswers.contains(answer) ?
                                                .semibold: .regular)
                                            .fixedSize(horizontal: false, vertical: true)
                                            .onTapGesture {
                                                quizManager.select(answer)
                                            }
                                    }
                                      
                                }
                            }
                        }
                    }
                    .padding(.leading)
                    

                    
                    Spacer()
                    Button {
                        quizManager.next()
                        
                    } label: {
                        Text(quizManager.isIncorrectState ? "Попробовать еще раз": "Далее")
                            .padding(.vertical, 10)
                            .frame(maxWidth: .infinity)
                            .foregroundColor(.white)
                            .background(Color.black)
                            .cornerRadius(10)
                    }
                        
      
                    
                    
                    .navigationTitle(quizManager.isIncorrectState ? randomErrorString() : "Вопрос №\(quizManager.currentQuestionIndex + 1) из \(quizManager.questions.count)")
                    
                    
                    .navigationBarTitleDisplayMode(.large)
                }
                .padding()
                .toolbar(content: {
                    Button {
                        presentAlert.toggle()
                    } label: {
                        Text("+")
                    }

                })
                .alert("№ вопроса", isPresented: $presentAlert, actions: {
                    
                    TextField("Номер вопроса", text: $quizManager.askedQuestion)
                           Button("Перейти", action: {
                               
                           })
                           Button("Отмена", role: .cancel, action: {})
                       }, message: {
                           Text("Куда перескочим?")
                       })
            }
            
        }
           
        
    }
}

struct MyPreviewProvider_Previews: PreviewProvider {
    static var previews: some View {
        QuizView()
            .environmentObject(QuizManager(currentQuestionIndex: 0))
    }
}

