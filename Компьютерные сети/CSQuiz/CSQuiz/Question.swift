//
//  Question.swift
//  CSQuiz
//
//  Created by Матвей Корепанов on 19.06.2023.
//

import Foundation

struct Question: Codable, Identifiable {
    var id = UUID()
    var title: String
    var answers: [String]
    var rightAnswers: [String]
    var image: String?
    
    enum CodingKeys: CodingKey {
        case title
        case answers
        case rightAnswers
        case image
    }
}
