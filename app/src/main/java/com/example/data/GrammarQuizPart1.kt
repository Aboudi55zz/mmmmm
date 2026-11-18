package com.example.data

import com.example.model.GrammarQuizQuestion

object GrammarQuizPart1 {
    val questions: List<GrammarQuizQuestion> = listOf(
        // Part 1: Present (8 questions)
        GrammarQuizQuestion(
            id = "q_u1_1",
            unitId = "u1_2",
            partId = "present",
            promptEn = "Are you hungry? — Yes, I ___.",
            promptAr = "اختر الإجابة القصيرة الصحيحة:",
            options = listOf("I'm", "am", "do", "is"),
            correctIndex = 1,
            explanationAr = "لا نستخدم الاختصار في الإجابة القصيرة المثبتة أبداً؛ الإجابة الصحيحة هي Yes, I am.",
            explanationEn = "Never use contractions in positive short answers: say 'Yes, I am', not 'Yes, I'm'."
        ),
        GrammarQuizQuestion(
            id = "q_u1_2",
            unitId = "u1_2",
            partId = "present",
            promptEn = "My shoes ___ very dirty. I need to clean them.",
            promptAr = "اختر فعل الكينونة المناسب للاسم الجمع:",
            options = listOf("is", "am", "are", "be"),
            correctIndex = 2,
            explanationAr = "كلمة shoes جمع دائماً في الإنجليزية، فتأخذ are.",
            explanationEn = "'shoes' is plural, so use 'are'."
        ),
        GrammarQuizQuestion(
            id = "q_u3_1",
            unitId = "u3_4",
            partId = "present",
            promptEn = "Please don't make so much noise. I ___ to work.",
            promptAr = "أكمل الجملة بالزمن المناسب للحظة الحالية:",
            options = listOf("try", "trying", "'m trying", "tries"),
            correctIndex = 2,
            explanationAr = "الحدث يقع الآن لحظة الكلام، لذلك نستخدم المضارع المستمر: I'm trying.",
            explanationEn = "The action is happening right now, so use Present Continuous: 'I'm trying'."
        ),
        GrammarQuizQuestion(
            id = "q_u3_2",
            unitId = "u3_4",
            partId = "present",
            promptEn = "Look! Somebody ___ in the river.",
            promptAr = "اختر الصيغة الصحيحة للمضارع المستمر:",
            options = listOf("swims", "is swiming", "is swimming", "swimming"),
            correctIndex = 2,
            explanationAr = "في المضارع المستمر نضاعف حرف m في swim لتصبح swimming مع is.",
            explanationEn = "Present Continuous: 'is' + 'swimming' (double the final 'm')."
        ),
        GrammarQuizQuestion(
            id = "q_u5_1",
            unitId = "u5_7",
            partId = "present",
            promptEn = "What time ___ the banks close here?",
            promptAr = "اختر الفعل المساعد الصحيح للسؤال في المضارع البسيط:",
            options = listOf("does", "do", "are", "is"),
            correctIndex = 1,
            explanationAr = "الفاعل (the banks) جمع، ومع الفعل الرئيسي (close) نستخدم do في السؤال.",
            explanationEn = "'the banks' is plural and 'close' is a main verb, so use 'do'."
        ),
        GrammarQuizQuestion(
            id = "q_u5_2",
            unitId = "u5_7",
            partId = "present",
            promptEn = "Sue ___ to work by bus every morning.",
            promptAr = "اختر تصريف الفعل الصحيح في المضارع البسيط:",
            options = listOf("go", "goes", "going", "is go"),
            correctIndex = 1,
            explanationAr = "مع الفاعل المفرد الغائب (Sue/she) نضيف -es للفعل المنتهي بـ o فتصبح goes.",
            explanationEn = "With 'she/Sue' in Present Simple, add '-es' to 'go' -> 'goes'."
        ),
        GrammarQuizQuestion(
            id = "q_u8_1",
            unitId = "u8_9",
            partId = "present",
            promptEn = "I'm sorry, I ___ the answer to your question.",
            promptAr = "اختر الصيغة الصحيحة للفعل know:",
            options = listOf("am not knowing", "not know", "don't know", "haven't got knowing"),
            correctIndex = 2,
            explanationAr = "الفعل know من أفعال الإدراك والحالة ولا يأتي في المضارع المستمر.",
            explanationEn = "'know' is a state verb, so use Present Simple ('don't know'), not continuous."
        ),
        GrammarQuizQuestion(
            id = "q_u8_2",
            unitId = "u8_9",
            partId = "present",
            promptEn = "___ a car? — Yes, she bought it last year.",
            promptAr = "اختر السؤال الصحيح للملكية:",
            options = listOf("Has she got", "Does she got", "Is she having", "Have she got"),
            correctIndex = 0,
            explanationAr = "للملكية مع المفرد الغائب نقول Has she got...? أو Does she have...?",
            explanationEn = "For possession with 'she', use 'Has she got...?' (or 'Does she have...?')."
        ),

        // Part 2: Past (5 questions)
        GrammarQuizQuestion(
            id = "q_u10_1",
            unitId = "u10_12",
            partId = "past",
            promptEn = "___ you go to the cinema last night?",
            promptAr = "أكمل السؤال في الماضي البسيط:",
            options = listOf("Were", "Did", "Do", "Was"),
            correctIndex = 1,
            explanationAr = "يوجد فعل رئيسي في المصدر (go)، لذلك نسأل في الماضي بـ Did.",
            explanationEn = "Use 'Did' with a main verb ('go') in Past Simple questions."
        ),
        GrammarQuizQuestion(
            id = "q_u10_2",
            unitId = "u10_12",
            partId = "past",
            promptEn = "Why ___ you late this morning?",
            promptAr = "اختر الماضي الصحيح لفعل الكينونة مع you:",
            options = listOf("did", "was", "were", "are"),
            correctIndex = 2,
            explanationAr = "لا يوجد فعل رئيسي في الجملة (late صفة)، لذلك نستخدم were مع you وليس did.",
            explanationEn = "'late' is an adjective (no main verb), so use 'were' with 'you', not 'did'."
        ),
        GrammarQuizQuestion(
            id = "q_u10_3",
            unitId = "u10_12",
            partId = "past",
            promptEn = "I didn't ___ TV yesterday evening.",
            promptAr = "اختر صيغة الفعل الصحيحة بعد didn't:",
            options = listOf("watched", "watching", "watch", "watches"),
            correctIndex = 2,
            explanationAr = "بعد did و didn't يعود الفعل دائماً للمصدر المجرد (watch).",
            explanationEn = "After 'didn't', always use the base verb ('watch')."
        ),
        GrammarQuizQuestion(
            id = "q_u13_1",
            unitId = "u13_14",
            partId = "past",
            promptEn = "I ___ along the street when suddenly I heard footsteps behind me.",
            promptAr = "أكمل الحدث المستمر الذي قطعه حدث آخر:",
            options = listOf("walked", "am walking", "was walking", "have walked"),
            correctIndex = 2,
            explanationAr = "الحدث المستمر في الخلفية يأخذ الماضي المستمر (was walking) والحدث القاطع يأخذ الماضي البسيط (heard).",
            explanationEn = "Use Past Continuous ('was walking') for the longer background action interrupted by 'heard'."
        ),
        GrammarQuizQuestion(
            id = "q_u13_2",
            unitId = "u13_14",
            partId = "past",
            promptEn = "What ___ at 10 o'clock last night? You didn't answer my call.",
            promptAr = "اسأل عن فعل كان مستمراً في وقت محدد بالماضي:",
            options = listOf("did you do", "were you doing", "you were doing", "are you doing"),
            correctIndex = 1,
            explanationAr = "للسؤال عما كان يحدث في لحظة محددة في الماضي نستخدم الماضي المستمر: were you doing.",
            explanationEn = "Use Past Continuous ('were you doing') for an action in progress at a specific past time."
        ),

        // Part 3: Present Perfect (5 questions)
        GrammarQuizQuestion(
            id = "q_u15_1",
            unitId = "u15_17",
            partId = "present_perfect",
            promptEn = "Where's David? — He's ___ to the shops. He'll be back soon.",
            promptAr = "اختر بين gone و been:",
            options = listOf("been", "went", "gone", "going"),
            correctIndex = 2,
            explanationAr = "لأنه لم يعد بعد وما زال في المتجر نستخدم has gone.",
            explanationEn = "Use 'gone' because David is still at the shops and hasn't returned yet."
        ),
        GrammarQuizQuestion(
            id = "q_u15_2",
            unitId = "u15_17",
            partId = "present_perfect",
            promptEn = "Has it stopped raining ___?",
            promptAr = "اختر الكلمة المناسبة في آخر السؤال في المضارع التام:",
            options = listOf("just", "already", "yet", "ever"),
            correctIndex = 2,
            explanationAr = "كلمة yet تأتي في نهاية الجملة المنفية والسؤال في المضارع التام بمعنى 'حتى الآن'.",
            explanationEn = "'yet' goes at the end of questions and negatives in Present Perfect."
        ),
        GrammarQuizQuestion(
            id = "q_u18_1",
            unitId = "u18_20",
            partId = "present_perfect",
            promptEn = "I've lived in this apartment ___ 2019.",
            promptAr = "اختر أداة الزمن المناسبة:",
            options = listOf("for", "ago", "since", "from"),
            correctIndex = 2,
            explanationAr = "2019 هي نقطة بداية محددة، ولذلك نستخدم since.",
            explanationEn = "2019 is a specific starting point in time, so use 'since'."
        ),
        GrammarQuizQuestion(
            id = "q_u18_2",
            unitId = "u18_20",
            partId = "present_perfect",
            promptEn = "Shakespeare ___ many famous plays.",
            promptAr = "اختر الزمن الصحيح (حدث في ماضٍ منتهٍ):",
            options = listOf("has written", "wrote", "was writing", "writes"),
            correctIndex = 1,
            explanationAr = "شكسبير متوفى والفترة منتهية تماماً، فنستخدم الماضي البسيط (wrote).",
            explanationEn = "Shakespeare is no longer alive, so his life is a finished past time -> Past Simple ('wrote')."
        ),
        GrammarQuizQuestion(
            id = "q_u18_3",
            unitId = "u18_20",
            partId = "present_perfect",
            promptEn = "How long ___ married?",
            promptAr = "اسأل عن مدة زواج ما زال مستمراً حتى الآن:",
            options = listOf("are they", "were they", "have they been", "did they be"),
            correctIndex = 2,
            explanationAr = "للمدة المستمرة من الماضي حتى الحاضر نستخدم المضارع التام (have they been)، وليس المضارع البسيط.",
            explanationEn = "Use Present Perfect ('have they been') for a state that started in the past and continues now."
        ),

        // Part 4: Passive (4 questions)
        GrammarQuizQuestion(
            id = "q_u21_1",
            unitId = "u21_22",
            partId = "passive",
            promptEn = "This bridge ___ in 1925.",
            promptAr = "اختر صيغة المبني للمجهول الصحيحة:",
            options = listOf("built", "is built", "was built", "has built"),
            correctIndex = 2,
            explanationAr = "الجسر مبني للمجهول وفي سنة ماضية محددة (1925)، فنستخدم was built.",
            explanationEn = "Past passive for a specific past year (1925): 'was built'."
        ),
        GrammarQuizQuestion(
            id = "q_u21_2",
            unitId = "u21_22",
            partId = "passive",
            promptEn = "Look! The street ___ at the moment.",
            promptAr = "اختر صيغة المبني للمجهول المستمر:",
            options = listOf("is cleaning", "is being cleaned", "was cleaned", "cleaned"),
            correctIndex = 1,
            explanationAr = "الشارع يُنظَّف الآن (مجهول + مستمر): is being cleaned.",
            explanationEn = "Present Continuous Passive ('is being cleaned') for an action happening right now."
        ),
        GrammarQuizQuestion(
            id = "q_u21_3",
            unitId = "u21_22",
            partId = "passive",
            promptEn = "Where ___ you born?",
            promptAr = "اختر الصيغة الصحيحة للسؤال عن مكان الميلاد:",
            options = listOf("are", "did", "were", "have"),
            correctIndex = 2,
            explanationAr = "الميلاد حدث في الماضي وبصيغة المبني للمجهول دائماً: Where were you born?",
            explanationEn = "'be born' is always Past Simple Passive: 'Where were you born?'."
        ),
        GrammarQuizQuestion(
            id = "q_u21_4",
            unitId = "u21_22",
            partId = "passive",
            promptEn = "My keys have ___! I can't find them anywhere.",
            promptAr = "أكمل جملة المضارع التام المبني للمجهول:",
            options = listOf("stole", "stolen", "been stolen", "being stolen"),
            correctIndex = 2,
            explanationAr = "المبني للمجهول في المضارع التام يتكون من have/has + been + V3.",
            explanationEn = "Present Perfect Passive is formed with 'have/has + been + V3'."
        ),

        // Part 5: Verb Forms (4 questions)
        GrammarQuizQuestion(
            id = "q_u23_1",
            unitId = "u23_24",
            partId = "verb_forms",
            promptEn = "Why didn't you ___ me earlier?",
            promptAr = "اختر الصيغة الصحيحة بعد didn't:",
            options = listOf("told", "telling", "tell", "tells"),
            correctIndex = 2,
            explanationAr = "بعد do / does / did يأتي الفعل دائماً في المصدر المجرد (tell).",
            explanationEn = "Always use the base form ('tell') after 'did' or 'didn't'."
        ),
        GrammarQuizQuestion(
            id = "q_u23_2",
            unitId = "u23_24",
            partId = "verb_forms",
            promptEn = "This window ___ yesterday afternoon.",
            promptAr = "اختر الصيغة الصحيحة للفعل مع be في الماضي:",
            options = listOf("was broke", "was broken", "has broken", "did break"),
            correctIndex = 1,
            explanationAr = "بعد be (was) للمجهول نستخدم التصريف الثالث (broken) وليس الماضي (broke).",
            explanationEn = "After 'was' for passive voice, use V3 ('broken'), never V2 ('broke')."
        ),
        GrammarQuizQuestion(
            id = "q_u23_3",
            unitId = "u23_24",
            partId = "verb_forms",
            promptEn = "Have you ever ___ a horse?",
            promptAr = "اختر التصريف الثالث للفعل ride:",
            options = listOf("rode", "rided", "ridden", "riding"),
            correctIndex = 2,
            explanationAr = "التصريفات الثلاثة للفعل هي ride - rode - ridden، وبعد have نستخدم V3.",
            explanationEn = "The irregular forms are ride - rode - ridden; use 'ridden' after 'have'."
        ),
        GrammarQuizQuestion(
            id = "q_u23_4",
            unitId = "u23_24",
            partId = "verb_forms",
            promptEn = "I ___ my glasses on the desk an hour ago, and now they're gone.",
            promptAr = "اختر الماضي الصحيح للفعل put:",
            options = listOf("putted", "put", "putting", "puts"),
            correctIndex = 1,
            explanationAr = "الفعل put من الأفعال التي لا تتغير في التصريفات الثلاثة (put - put - put).",
            explanationEn = "'put' has the same form in present, past, and past participle (put - put - put)."
        ),

        // Part 6: Future (5 questions)
        GrammarQuizQuestion(
            id = "q_u25_1",
            unitId = "u25_26",
            partId = "future",
            promptEn = "Look at those dark clouds! It ___ rain.",
            promptAr = "توقع مبني على دليل حالي واضح:",
            options = listOf("is going to", "will be", "going to", "rains"),
            correctIndex = 0,
            explanationAr = "عند وجود دليل واضح في الحاضر (غيوم سوداء) نستخدم is going to.",
            explanationEn = "Use 'going to' for predictions based on visible present evidence."
        ),
        GrammarQuizQuestion(
            id = "q_u25_2",
            unitId = "u25_26",
            partId = "future",
            promptEn = "We ___ tennis with Alex tomorrow at 4pm. We booked the court.",
            promptAr = "اختر الزمن المناسب لترتيب مستقبلي مؤكد:",
            options = listOf("play", "'re playing", "will played", "played"),
            correctIndex = 1,
            explanationAr = "للترتيبات والمواعيد المحجوزة مسبقاً نستخدم المضارع المستمر (are playing).",
            explanationEn = "Use Present Continuous ('are playing') for fixed future arrangements."
        ),
        GrammarQuizQuestion(
            id = "q_u25_3",
            unitId = "u25_26",
            partId = "future",
            promptEn = "What time ___ the train leave tonight?",
            promptAr = "اختر الفعل المساعد لجدول مواعيد رسمي:",
            options = listOf("is", "will be", "does", "has"),
            correctIndex = 2,
            explanationAr = "مواعيد القطارات والطائرات الرسمية تُعبّر بالمضارع البسيط (does the train leave).",
            explanationEn = "Public timetables (trains, flights) use Present Simple: 'What time does the train leave?'."
        ),
        GrammarQuizQuestion(
            id = "q_u27_1",
            unitId = "u27_28",
            partId = "future",
            promptEn = "The phone is ringing! — Don't worry, I ___ answer it.",
            promptAr = "قرار لحظي فوري:",
            options = listOf("'m going to", "'ll", "am", "do"),
            correctIndex = 1,
            explanationAr = "للقرارات السريعة التي تُتخذ لحظة الكلام نستخدم will ('ll).",
            explanationEn = "Use 'will' ('ll) for instant decisions made at the moment of speaking."
        ),
        GrammarQuizQuestion(
            id = "q_u27_2",
            unitId = "u27_28",
            partId = "future",
            promptEn = "It's warm in here. ___ I open the window?",
            promptAr = "اختر الصيغة المهذبة لتقديم عرض أو اقتراح:",
            options = listOf("Will", "Shall", "Am", "Do"),
            correctIndex = 1,
            explanationAr = "نستخدم Shall I...? أو Shall we...? لتقديم عرض مساعدة أو اقتراح.",
            explanationEn = "Use 'Shall I...?' or 'Shall we...?' to make polite offers and suggestions."
        ),

        // Part 7: Modals (5 questions)
        GrammarQuizQuestion(
            id = "q_u29_1",
            unitId = "u29_31",
            partId = "modals",
            promptEn = "We have plenty of time. You ___ hurry.",
            promptAr = "عبّر عن عدم وجود حاجة أو ضرورة:",
            options = listOf("mustn't", "needn't", "couldn't", "should"),
            correctIndex = 1,
            explanationAr = "needn't تعني 'لا داعي / لست مضطراً'، بينما mustn't تعني 'ممنوع'.",
            explanationEn = "'needn't' means it is not necessary, whereas 'mustn't' means it is forbidden."
        ),
        GrammarQuizQuestion(
            id = "q_u29_2",
            unitId = "u29_31",
            partId = "modals",
            promptEn = "Take an umbrella with you. It ___ rain later.",
            promptAr = "عبّر عن احتمال غير مؤكد (ربما):",
            options = listOf("must", "might", "has to", "needn't"),
            correctIndex = 1,
            explanationAr = "نستخدم might للتعبير عن الاحتمال غير المؤكد (50%).",
            explanationEn = "'might' expresses possibility in the present or future."
        ),
        GrammarQuizQuestion(
            id = "q_u29_3",
            unitId = "u29_31",
            partId = "modals",
            promptEn = "You ___ touch that wire! It's dangerous.",
            promptAr = "عبّر عن المنع والتحذير (ممنوع):",
            options = listOf("needn't", "don't have to", "mustn't", "might not"),
            correctIndex = 2,
            explanationAr = "للمنع والتحذير الشديد نستخدم mustn't (لا يجوز بتاتاً).",
            explanationEn = "Use 'mustn't' for strict prohibition ('Do NOT do it')."
        ),
        GrammarQuizQuestion(
            id = "q_u32_1",
            unitId = "u32_36",
            partId = "modals",
            promptEn = "When I was a child, I ___ play football every day.",
            promptAr = "اختر التعبير المناسب لعادة قديمة انتهت:",
            options = listOf("use to", "was used to", "used to", "am used to"),
            correctIndex = 2,
            explanationAr = "للعادات الماضية التي توقفت نستخدم used to + المصدر بدون was/am.",
            explanationEn = "Use 'used to + base verb' for past habits that are no longer true."
        ),
        GrammarQuizQuestion(
            id = "q_u32_2",
            unitId = "u32_36",
            partId = "modals",
            promptEn = "Last night the bus didn't come, so I ___ walk home.",
            promptAr = "عبّر عن الإلزام في الماضي:",
            options = listOf("must", "have to", "had to", "should"),
            correctIndex = 2,
            explanationAr = "لا يوجد ماضٍ لـ must؛ في الماضي نستخدم had to دائماً.",
            explanationEn = "'must' has no past tense — always use 'had to' for past obligation."
        ),

        // Part 8: There & It (4 questions)
        GrammarQuizQuestion(
            id = "q_u37_1",
            unitId = "u37_39",
            partId = "there_it",
            promptEn = "How far ___ from here to the station?",
            promptAr = "اختر الضمير الصحيح للسؤال عن المسافة:",
            options = listOf("there is", "is there", "it is", "is it"),
            correctIndex = 3,
            explanationAr = "للمسافة والطقس والوقت نستخدم It، وفي السؤال نعكسها إلى is it.",
            explanationEn = "Use 'it' for distance, and invert for questions: 'How far is it...?'"
        ),
        GrammarQuizQuestion(
            id = "q_u37_2",
            unitId = "u37_39",
            partId = "there_it",
            promptEn = "___ a lot of traffic on the road this morning.",
            promptAr = "اختر الفعل الصحيح مع كلمة traffic (غير معدودة):",
            options = listOf("There were", "There was", "It was", "There are"),
            correctIndex = 1,
            explanationAr = "traffic غير معدودة فتأخذ فعلاً مفرداً (was)، وللوجود نستخدم There was.",
            explanationEn = "'traffic' is uncountable and singular, so use 'There was'."
        ),
        GrammarQuizQuestion(
            id = "q_u37_3",
            unitId = "u37_39",
            partId = "there_it",
            promptEn = "I like this hotel. ___ very comfortable.",
            promptAr = "أكمل الجملة لوصف الشيء الذي ذكرته للتو:",
            options = listOf("There is", "It is", "There's", "They are"),
            correctIndex = 1,
            explanationAr = "لوصف شيء محدد ذُكر للتو (this hotel) نستخدم It is وليس There is.",
            explanationEn = "Use 'It is' to describe a specific thing already mentioned."
        ),
        GrammarQuizQuestion(
            id = "q_u37_4",
            unitId = "u37_39",
            partId = "there_it",
            promptEn = "Look at that restaurant! ___ any empty tables inside?",
            promptAr = "اسأل عن وجود طاولات (جمع):",
            options = listOf("Is there", "Are there", "Are it", "Have there"),
            correctIndex = 1,
            explanationAr = "empty tables جمع، وفي السؤال عن الوجود نستخدم Are there...?",
            explanationEn = "For plural nouns in existence questions, use 'Are there...?'."
        ),

        // Part 9: Auxiliaries (5 questions)
        GrammarQuizQuestion(
            id = "q_u40_1",
            unitId = "u40_43",
            partId = "auxiliaries",
            promptEn = "I don't like noisy places. — ___.",
            promptAr = "اختر صيغة الموافقة الصحيحة على النفي:",
            options = listOf("So do I", "Neither don't I", "Neither do I", "So don't I"),
            correctIndex = 2,
            explanationAr = "للموافقة على جملة منفية في المضارع البسيط نقول Neither do I.",
            explanationEn = "To agree with a negative Present Simple statement, say 'Neither do I'."
        ),
        GrammarQuizQuestion(
            id = "q_u40_2",
            unitId = "u40_43",
            partId = "auxiliaries",
            promptEn = "Kate wasn't at the meeting, ___?",
            promptAr = "أكمل السؤال الذيلي (Question Tag):",
            options = listOf("wasn't she", "did she", "was she", "is she"),
            correctIndex = 2,
            explanationAr = "الجملة منفية (wasn't)، لذا يكون السؤال الذيلي مثبتاً باستخدام نفس الفعل المساعد: was she?",
            explanationEn = "Negative statement ('wasn't') takes a positive tag with the same verb: 'was she?'."
        ),
        GrammarQuizQuestion(
            id = "q_u40_3",
            unitId = "u40_43",
            partId = "auxiliaries",
            promptEn = "I've seen that film twice. — Oh, ___? Did you like it?",
            promptAr = "اختر الرد القصير لإظهار الاهتمام:",
            options = listOf("did you", "have you", "do you", "were you"),
            correctIndex = 1,
            explanationAr = "الجملة في المضارع التام (I've seen)، لذا نكرر نفس الفعل المساعد في الرد: Oh, have you?",
            explanationEn = "Match the auxiliary from the statement ('have seen' -> 'Oh, have you?')."
        ),
        GrammarQuizQuestion(
            id = "q_u40_4",
            unitId = "u40_43",
            partId = "auxiliaries",
            promptEn = "Mark works in a bank. — ___ does his sister.",
            promptAr = "اختر صيغة الموافقة للجملة المثبتة:",
            options = listOf("Too", "Neither", "So", "Also"),
            correctIndex = 2,
            explanationAr = "للموافقة بصيغة (وكذلك أخته) نبدأ بـ So + الفعل المساعد + الفاعل.",
            explanationEn = "Use 'So + auxiliary + subject' ('So does his sister') to agree with positive statements."
        ),
        GrammarQuizQuestion(
            id = "q_u40_5",
            unitId = "u40_43",
            partId = "auxiliaries",
            promptEn = "Your brother plays the guitar, ___?",
            promptAr = "أكمل السؤال الذيلي لفعل مضارع بسيط:",
            options = listOf("isn't he", "doesn't he", "don't he", "does he"),
            correctIndex = 1,
            explanationAr = "الجملة مثبتة في المضارع البسيط مع he، فنستخدم doesn't he? في السؤال الذيلي.",
            explanationEn = "Positive Present Simple with 'he/she/it' takes 'doesn't he/she?'."
        ),

        // Part 10: Questions & Reported Speech (5 questions)
        GrammarQuizQuestion(
            id = "q_u44_1",
            unitId = "u44_48",
            partId = "questions_reported",
            promptEn = "Do you know where ___?",
            promptAr = "اختر الترتيب الصحيح للسؤال غير المباشر:",
            options = listOf("does Tom live", "lives Tom", "Tom lives", "is Tom live"),
            correctIndex = 2,
            explanationAr = "بعد Do you know لا نضع do/does بل نرتب الجملة كخبر (فاعل ثم فعل): Tom lives.",
            explanationEn = "Indirect questions use statement word order: 'where Tom lives'."
        ),
        GrammarQuizQuestion(
            id = "q_u44_2",
            unitId = "u44_48",
            partId = "questions_reported",
            promptEn = "Who ___ you this morning? — My sister phoned me.",
            promptAr = "سؤال عن الفاعل (Subject Question):",
            options = listOf("did phone", "phoned", "did phoned", "was phone"),
            correctIndex = 1,
            explanationAr = "عندما نسأل بـ Who عن الفاعل الذي قام بالفعل لا نستخدم did؛ نقول Who phoned you?",
            explanationEn = "When 'Who' is the subject, do NOT use 'did': 'Who phoned you?'."
        ),
        GrammarQuizQuestion(
            id = "q_u44_3",
            unitId = "u44_48",
            partId = "questions_reported",
            promptEn = "What are you talking ___?",
            promptAr = "اختر موقع حرف الجر الصحيح في السؤال:",
            options = listOf("about it", "about", "for it", "of it"),
            correctIndex = 1,
            explanationAr = "في السؤال يبقى حرف الجر في نهاية الجملة بدون إضافة it بعده.",
            explanationEn = "Put the preposition at the end of the question without adding 'it'."
        ),
        GrammarQuizQuestion(
            id = "q_u49_1",
            unitId = "u49_50",
            partId = "questions_reported",
            promptEn = "Sarah ___ me that she was going away.",
            promptAr = "اختر بين said و told:",
            options = listOf("said", "told", "spoke", "talked"),
            correctIndex = 1,
            explanationAr = "لوجود مفعول به مباشر (me) بدون حرف الجر to نستخدم told.",
            explanationEn = "'told' is followed directly by a person ('told me'); 'said' would require 'to me'."
        ),
        GrammarQuizQuestion(
            id = "q_u49_2",
            unitId = "u49_50",
            partId = "questions_reported",
            promptEn = "Direct: 'I can't swim.' -> Reported: He said he ___ swim.",
            promptAr = "حوّل الفعل في الكلام المنقول:",
            options = listOf("can't", "couldn't", "didn't can", "won't"),
            correctIndex = 1,
            explanationAr = "في الكلام المنقول يتحول can / can't خطوة للماضي إلى could / couldn't.",
            explanationEn = "In reported speech, 'can't' shifts back to 'couldn't'."
        )
    )
}
