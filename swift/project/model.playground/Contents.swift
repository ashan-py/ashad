import UIKit

///추상화
///이름, 별명, 생일, 성별, 사는 곳, 키, 몸무계, 성격, 휴대폰 번호

extension Double {
    static let reviewScoreFormatter = {
        let formatter = NumberFormatter()
        formatter.minimumFractionDigits = 0
        formatter.maximumFractionDigits = 1
        
        return formatter
    }()
    var reviewScoreString: String? {
        return Self.reviewScoreFormatter.string(for: self)
    }
    
    static let priceFormatter = {
        let formatter = NumberFormatter()
        formatter.numberStyle = .currency
        formatter.locale = Locale(identifier: "ko_KR")
        
        return formatter
    }()
    
    var priceString: String? {
        return Self.priceFormatter.string(for: self)
    }
}
extension String {
    var url: URL? {
        URL(string: self)
    }
}


class Service {
    let title: String // 상수 저장 속성, Stored Property
    let subtitle: String
    let cardImagUrl: String
    // let cardImageUrl: URL
    // 계산 속성. Computed Property
    let thumnailImageUrl: String?
    // static 붙이면 Type Property 타입 속성, 형식 속성
    let reviewScore: Double?
    let isCertificationAvailable: Bool
    
    init(title: String, subtitle: String, cardImagUrlStr: String, thumnailImageUrlStr: String?, reviewScore: Double?, isCertificationAvailable: Bool) {
        self.title = title
        self.subtitle = subtitle
        self.cardImagUrl = cardImagUrlStr
        self.thumnailImageUrl = thumnailImageUrlStr
        self.reviewScore = reviewScore
        self.isCertificationAvailable = isCertificationAvailable
    }
}


extension Int {
    static let duractionFormatter = {
        let formatter = DateComponentsFormatter()
        formatter.allowedUnits = [.hour, .minute]
        formatter.unitsStyle = .full
        
        return formatter
    }()
    
    var durationString: String? {
        return Self.duractionFormatter.string(from: TimeInterval(self))
    }
}





class course: Service {
    let courseId: Int
    
    // 인스턴스 속성. instance property
    
    
    var isFree: Bool {
        return price == nil
    }
    let lectureCount: Int
    let totalCuration: Int
    let priority: Int
    let isPublic: Bool
    let period: Int?
    let price: Double?
    let discontedPrice: Double?
    
    
    
    var priceSting: String? {
        guard let price else { return "무료"}
        
        if let discontedPrice {
            return discontedPrice.priceString
        }
        
        return price.priceString
        
        
    }
    
    
    init(courseId: Int, lectureCount: Int, totalCuration: Int, priority: Int,
         isPublic: Bool, period: Int?, price: Double?, discontedPrice: Double?,
         title: String, subtitle: String, cardImagUrlStr: String, thumnailImageUrlStr: String?,
         reviewScore: Double?, isCertificationAvailable: Bool) {
        
        self.courseId = courseId
        self.lectureCount = lectureCount
        self.totalCuration = totalCuration
        self.priority = priority
        self.isPublic = isPublic
        self.period = period
        self.price = price
        self.discontedPrice = discontedPrice
        
        super.init(title: title, subtitle: subtitle, cardImagUrlStr: cardImagUrlStr,
                   thumnailImageUrlStr: thumnailImageUrlStr, reviewScore: reviewScore,
                   isCertificationAvailable: isCertificationAvailable)
    }
}
//    init() {
//        formatter.minimumFractionDigits = 0
//        formatter.maximumFractionDigits = 1
    
extension Date {
    static let formatter = DateFormatter()
        
    func format(with format: String, locale: Locale = Locale(identifier: "ko_kr")) -> String {
        Self.formatter.dateFormat = format
        Self.formatter.locale = locale
        
        return Self.formatter.string(from: self)
        
    }
}
class Camp: Service {
    let campId: Int
    
    // 인스턴스 속성. instance property
    
    let startDate: Date
    let endDate: Date
    let isOnlineCamp: Bool
    let locationUrl : URL?
    let latitude: Double?
    let longitude: Double?
    
    
    enum Status: String {
        case preparingForOpening    = "개강 준비중"
        case recruiting             = "모집중"
        case recruitingEnded        = "모집마감"
        case onGoing                = "개강중"
        case ended                  = "종강"
    }
    
    let status: Status
    let generation: Int
    var statusString: String? {
        return "\(generation)기 \(status.rawValue)"
    }
    
    let priority: Int
    let isPublic: Bool
    let price: Double?
    let discountPrice: Double?
    
    var priceString: String? {
        guard let price else { return "무료" }
      
        if let discountPrice {
            return discountPrice.priceString
        }
        return price.priceString
    }
    init(
        title: String, subtitle: String, cardImagUrlStr: String, thumnailImageUrlStr: String? = nil,
         reviewScore: Double? = nil, isCertificationAvailable: Bool = true, campId: Int, startDate: Date,
        endDate: Date, isOnlineCamp: Bool = true, locationUrl: URL? = nil, latitude: Double? = nil, longitude: Double? = nil,
        status: Status = .preparingForOpening, generation: Int, priority: Int, isPublic: Bool, price: Double?,
        discountPrice: Double? = nil) {
        self.campId = campId
        self.startDate = startDate
        self.endDate = endDate
        self.isOnlineCamp = isOnlineCamp
        self.locationUrl = locationUrl
        self.latitude = latitude
        self.longitude = longitude
        self.status = status
        self.generation = generation
        self.priority = priority
        self.isPublic = isPublic
        self.price = price
        self.discountPrice = discountPrice
        
        super.init(title: title, subtitle: subtitle, cardImagUrlStr: cardImagUrlStr, thumnailImageUrlStr: thumnailImageUrlStr, reviewScore: reviewScore, isCertificationAvailable: isCertificationAvailable)
    }
}
    


struct upateHistory {
    let upateHistoryId: Int
    
    let version: Int
    
    let updatedDate: Date
    
    var updatedDateStr: String {
        let formatter = DateFormatter()
        formatter.dateStyle = .full
        formatter.timeStyle = .none
        
        formatter.dateFormat = "yyyy년 M월 d일"
        formatter.locale = Locale(identifier: "ko_kr")
        
        return formatter.string(from: updatedDate)
    }
    
    let updateLog: String
    
}































class Person {
    let name: String
    let age: Int
    
    init(name: String, age: Int) {
        self.name = name
        self.age = age
    }
    
}


class Member: Person {
    let height: Double
    let weight: Double
    
    init(name: String, age: Int, height: Double, weight: Double) {
        self.height = height
        self.weight = weight
        
        super.init(name: name, age: age)
    }
}

class Employee: Person {
    let department: String
    let rank: String
    init(name: String, age: Int, department: String, rank: String) {
        self.department = department
        self.rank = rank
        super.init(name: name, age: age)
    }
}

let e = Employee(name: "강병진", age: 22, department: "학생", rank: "2")
e.department






