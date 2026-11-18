package com.example.data

import com.example.model.GrammarQuizQuestion

object GrammarQuizPart2 {
    val questions: List<GrammarQuizQuestion> = listOf(
        // Part 11: -ing & to... (5 questions)
        GrammarQuizQuestion(
            id = "q_u51_1",
            unitId = "u51_54",
            partId = "ing_to",
            promptEn = "She left the room without ___ a word.",
            promptAr = "اختر الصيغة الصحيحة بعد حرف الجر without:",
            options = listOf("say", "to say", "saying", "said"),
            correctIndex = 2,
            explanationAr = "بعد جميع حروف الجر (مثل without, before, for) يأخذ الفعل -ing.",
            explanationEn = "After any preposition ('without'), always use the -ing form ('saying')."
        ),
        GrammarQuizQuestion(
            id = "q_u51_2",
            unitId = "u51_54",
            partId = "ing_to",
            promptEn = "I'm going to the supermarket ___ some bread.",
            promptAr = "عبّر عن الغرض من الذهاب:",
            options = listOf("for buy", "to buy", "for buying", "buying"),
            correctIndex = 1,
            explanationAr = "لبيان الغرض أو السبب نستخدم to + المصدر (to buy).",
            explanationEn = "Use 'to + base verb' ('to buy') to express purpose."
        ),
        GrammarQuizQuestion(
            id = "q_u51_3",
            unitId = "u51_54",
            partId = "ing_to",
            promptEn = "Would you mind ___ the window? It's cold.",
            promptAr = "اختر الصيغة الصحيحة بعد الفعل mind:",
            options = listOf("to close", "close", "closing", "closed"),
            correctIndex = 2,
            explanationAr = "الفعل mind يتبعه دائماً الفعل مضافاً له -ing.",
            explanationEn = "'mind' is always followed by the -ing form ('closing')."
        ),
        GrammarQuizQuestion(
            id = "q_u51_4",
            unitId = "u51_54",
            partId = "ing_to",
            promptEn = "They decided ___ to Spain for their holiday.",
            promptAr = "اختر الصيغة الصحيحة بعد الفعل decide:",
            options = listOf("going", "go", "to go", "for going"),
            correctIndex = 2,
            explanationAr = "الفعل decide يتبعه دائماً to + المصدر (to go).",
            explanationEn = "'decide' is followed by 'to + base verb' ('to go')."
        ),
        GrammarQuizQuestion(
            id = "q_u51_5",
            unitId = "u51_54",
            partId = "ing_to",
            promptEn = "Please wait! I want ___ me with this box.",
            promptAr = "أكمل جملة want مع مفعول به:",
            options = listOf("that you help", "you helping", "you to help", "you help"),
            correctIndex = 2,
            explanationAr = "التركيب الصحيح هو want + شخص + to + المصدر (want you to help)، ولا نستخدم that.",
            explanationEn = "Use 'want + someone + to do', never 'want that...'."
        ),

        // Part 12: Go, Get, Do, Make, Have (5 questions)
        GrammarQuizQuestion(
            id = "q_u55_1",
            unitId = "u55_58",
            partId = "go_get_do_make",
            promptEn = "Don't worry if you ___ a mistake; everyone learns that way.",
            promptAr = "اختر الفعل المناسب مع كلمة mistake:",
            options = listOf("do", "make", "get", "have"),
            correctIndex = 1,
            explanationAr = "نقول دائماً make a mistake وليس do a mistake.",
            explanationEn = "The correct collocation is 'make a mistake'."
        ),
        GrammarQuizQuestion(
            id = "q_u55_2",
            unitId = "u55_58",
            partId = "go_get_do_make",
            promptEn = "I have to ___ my homework before dinner.",
            promptAr = "اختر الفعل المناسب مع الواجب المنزلي (homework):",
            options = listOf("make", "do", "get", "go"),
            correctIndex = 1,
            explanationAr = "مع homework و housework و exams نستخدم الفعل do دائماً.",
            explanationEn = "Use 'do' with homework, housework, and exams."
        ),
        GrammarQuizQuestion(
            id = "q_u55_3",
            unitId = "u55_58",
            partId = "go_get_do_make",
            promptEn = "Put on your coat! It's ___ very cold outside.",
            promptAr = "اختر الفعل بمعنى 'يصبح' قبل الصفة cold:",
            options = listOf("making", "doing", "getting", "having"),
            correctIndex = 2,
            explanationAr = "نستخدم get + صفة للتعبير عن التحول والتغير (getting cold = يزداد برودة).",
            explanationEn = "Use 'get + adjective' ('getting cold') to mean 'become'."
        ),
        GrammarQuizQuestion(
            id = "q_u55_4",
            unitId = "u55_58",
            partId = "go_get_do_make",
            promptEn = "Let's go ___ this afternoon. The pool is open.",
            promptAr = "اختر الصيغة الصحيحة بعد go للأنشطة:",
            options = listOf("to swim", "swimming", "for swim", "swim"),
            correctIndex = 1,
            explanationAr = "مع الرياضات والأنشطة (swimming, shopping, running) نستخدم go + V-ing.",
            explanationEn = "Use 'go + -ing' for activities like swimming and shopping."
        ),
        GrammarQuizQuestion(
            id = "q_u55_5",
            unitId = "u55_58",
            partId = "go_get_do_make",
            promptEn = "Did you ___ a good time at the party?",
            promptAr = "اختر الفعل المناسب في عبارة 'قضاء وقت ممتع':",
            options = listOf("make", "do", "have", "go"),
            correctIndex = 2,
            explanationAr = "نقول دائماً have a good time / have breakfast / have a shower.",
            explanationEn = "The natural expression is 'have a good time'."
        ),

        // Part 13: Pronouns & Possessives (5 questions)
        GrammarQuizQuestion(
            id = "q_u59_1",
            unitId = "u59_64",
            partId = "pronouns",
            promptEn = "Is this umbrella ___? — No, it isn't mine.",
            promptAr = "اختر ضمير الملكية الصحيح:",
            options = listOf("your", "you", "yours", "yourself"),
            correctIndex = 2,
            explanationAr = "لعدم وجود اسم بعد الضمير نستخدم ضمير الملكية yours.",
            explanationEn = "Use 'yours' when there is no noun following it."
        ),
        GrammarQuizQuestion(
            id = "q_u59_2",
            unitId = "u59_64",
            partId = "pronouns",
            promptEn = "A friend of ___ is visiting from Canada next week.",
            promptAr = "أكمل التركيب الصحيح بعد of:",
            options = listOf("me", "my", "mine", "myself"),
            correctIndex = 2,
            explanationAr = "بعد of في الملكية نستخدم ضمير الملكية (a friend of mine / yours / hers).",
            explanationEn = "Say 'a friend of mine/yours/hers', not 'of me/my'."
        ),
        GrammarQuizQuestion(
            id = "q_u59_3",
            unitId = "u59_64",
            partId = "pronouns",
            promptEn = "Be careful with that sharp knife or you'll cut ___.",
            promptAr = "اختر الضمير الانعكاسي الصحيح:",
            options = listOf("you", "yours", "yourself", "yourselves me"),
            correctIndex = 2,
            explanationAr = "عندما يعود الفعل على الفاعل نفسه (you) نستخدم الضمير الانعكاسي yourself.",
            explanationEn = "Use the reflexive pronoun 'yourself' when subject and object are the same."
        ),
        GrammarQuizQuestion(
            id = "q_u59_4",
            unitId = "u59_64",
            partId = "pronouns",
            promptEn = "Sarah and Mark haven't spoken to ___ for months.",
            promptAr = "اختر التعبير المناسب للتفاعل المتبادل بين شخصين:",
            options = listOf("themselves", "each other", "them", "ourselves"),
            correctIndex = 1,
            explanationAr = "للمعنى المتبادل (أحدهما الآخر) نستخدم each other وليس themselves.",
            explanationEn = "Use 'each other' for reciprocal actions between two people."
        ),
        GrammarQuizQuestion(
            id = "q_u59_5",
            unitId = "u59_64",
            partId = "pronouns",
            promptEn = "Have you seen ___ car? It's parked outside.",
            promptAr = "اختر صيغة الملكية الصحيحة مع الأسماء:",
            options = listOf("the car of John", "John's", "Johns'", "John"),
            correctIndex = 1,
            explanationAr = "للملكية مع الأشخاص نستخدم 's: John's car.",
            explanationEn = "Use 's for people's possessions: 'John's car'."
        ),

        // Part 14: Articles & Nouns (8 questions - 2 per unit)
        GrammarQuizQuestion(
            id = "q_u65_1",
            unitId = "u65_68",
            partId = "articles_nouns",
            promptEn = "I need ___ about train times, please.",
            promptAr = "اختر العبارة الصحيحة لغير المعدود:",
            options = listOf("an information", "some informations", "some information", "many information"),
            correctIndex = 2,
            explanationAr = "كلمة information غير معدودة لا تأخذ an ولا تُجمع بـ s، فنستخدم some information.",
            explanationEn = "'information' is uncountable (no 'an', no plural '-s'). Use 'some information'."
        ),
        GrammarQuizQuestion(
            id = "q_u65_2",
            unitId = "u65_68",
            partId = "articles_nouns",
            promptEn = "We waited for ___ hour at the airport.",
            promptAr = "اختر أداة التنكير حسب النطق الصوتي:",
            options = listOf("a", "an", "the a", "some"),
            correctIndex = 1,
            explanationAr = "حرف h في hour صامت وتبدأ الكلمة بصوت علة، لذا نستخدم an hour.",
            explanationEn = "The 'h' in 'hour' is silent, so it starts with a vowel sound -> 'an hour'."
        ),
        GrammarQuizQuestion(
            id = "q_u69_1",
            unitId = "u69_70",
            partId = "articles_nouns",
            promptEn = "___ are very intelligent animals.",
            promptAr = "اختر الصيغة الصحيحة للتعميم العام:",
            options = listOf("The dolphins", "Dolphins", "A dolphin", "The dolphin's"),
            correctIndex = 1,
            explanationAr = "عند الحديث عن فئة أو نوع بشكل عام في الجمع لا نستخدم the.",
            explanationEn = "Do not use 'the' when making general statements with plural nouns."
        ),
        GrammarQuizQuestion(
            id = "q_u69_2",
            unitId = "u69_70",
            partId = "articles_nouns",
            promptEn = "I bought a jacket and a shirt. ___ jacket was expensive.",
            promptAr = "اختر الأداة المناسبة عند ذكر الشيء للمرة الثانية:",
            options = listOf("A", "An", "The", "No article"),
            correctIndex = 2,
            explanationAr = "عند الإشارة إلى شيء سبق ذكره ويعرفه المستمع نستخدم the.",
            explanationEn = "Use 'The' when referring back to something already mentioned."
        ),
        GrammarQuizQuestion(
            id = "q_u71_1",
            unitId = "u71_73",
            partId = "articles_nouns",
            promptEn = "My sister lives in ___.",
            promptAr = "اختر الصيغة الصحيحة مع أسماء الدول:",
            options = listOf("the Egypt", "USA", "the USA", "the London"),
            correctIndex = 2,
            explanationAr = "الدول بصيغة الجمع أو المركبة مثل the USA و the UK تأخذ the، عكس الدول المفردة والمدن.",
            explanationEn = "Plural or union country names take 'the' ('the USA', 'the UK'); single countries and cities do not."
        ),
        GrammarQuizQuestion(
            id = "q_u71_2",
            unitId = "u71_73",
            partId = "articles_nouns",
            promptEn = "I'm tired. I'm going ___ now. Goodnight!",
            promptAr = "اختر العبارة الصحيحة مع كلمة bed:",
            options = listOf("to the bed", "to bed", "at the bed", "in a bed"),
            correctIndex = 1,
            explanationAr = "مع الأماكن الروتينية كغرض أساسي (go to bed / go to work / go home) لا نستخدم the.",
            explanationEn = "Say 'go to bed' (without 'the') for sleeping."
        ),
        GrammarQuizQuestion(
            id = "q_u74_1",
            unitId = "u74_75",
            partId = "articles_nouns",
            promptEn = "I don't like the red shoes; I prefer the blue ___.",
            promptAr = "اختر البديل الصحيح للجمع لتجنب تكرار الاسم:",
            options = listOf("one", "ones", "it", "them"),
            correctIndex = 1,
            explanationAr = "للجمع المعدود نستخدم ones بديلاً للاسم، وللمفرد نستخدم one.",
            explanationEn = "Use 'ones' to replace a plural countable noun ('shoes')."
        ),
        GrammarQuizQuestion(
            id = "q_u74_2",
            unitId = "u74_75",
            partId = "articles_nouns",
            promptEn = "My laptop is broken. I need to buy a new ___.",
            promptAr = "اختر البديل الصحيح للمفرد المعدود:",
            options = listOf("ones", "one", "it", "that one's"),
            correctIndex = 1,
            explanationAr = "لتعويض الاسم المفرد المعدود (laptop) نستخدم one بعد الصفة.",
            explanationEn = "Use 'one' after an adjective to replace a singular countable noun."
        ),

        // Part 15: Determiners & Quantifiers (6 questions - 2 per unit)
        GrammarQuizQuestion(
            id = "q_u76_1",
            unitId = "u76_79",
            partId = "determiners",
            promptEn = "There isn't ___ milk left in the fridge.",
            promptAr = "أكمل الجملة المنفية:",
            options = listOf("some", "many", "any", "a few"),
            correctIndex = 2,
            explanationAr = "في الجملة المنفية ومع غير المعدود (milk) نستخدم any.",
            explanationEn = "Use 'any' in negative sentences with uncountable nouns."
        ),
        GrammarQuizQuestion(
            id = "q_u76_2",
            unitId = "u76_79",
            partId = "determiners",
            promptEn = "Everybody ___ ready for the trip.",
            promptAr = "اختر الفعل الصحيح مع everybody:",
            options = listOf("are", "is", "were", "have"),
            correctIndex = 1,
            explanationAr = "الكلمات المركبة مثل everybody و nobody و nothing تأخذ فعلاً مفرداً دائماً (is).",
            explanationEn = "Indefinite pronouns like 'everybody' always take a singular verb ('is')."
        ),
        GrammarQuizQuestion(
            id = "q_u80_1",
            unitId = "u80_82",
            partId = "determiners",
            promptEn = "There are two trains to Oxford. You can take ___ train.",
            promptAr = "اختر الكلمة المناسبة للخيار بين اثنين:",
            options = listOf("both", "all", "either", "every"),
            correctIndex = 2,
            explanationAr = "للاختيار بين اثنين فقط نستخدم either + اسم مفرد.",
            explanationEn = "'either' + singular noun means one or the other of two options."
        ),
        GrammarQuizQuestion(
            id = "q_u80_2",
            unitId = "u80_82",
            partId = "determiners",
            promptEn = "___ answers were wrong, so we tried a third way.",
            promptAr = "اختر الكلمة المناسبة للحديث عن إجابتين معاً:",
            options = listOf("Every", "Both", "Either", "Much"),
            correctIndex = 1,
            explanationAr = "للجمع بين شيئين اثنين مع فعل جمع (were) نستخدم Both.",
            explanationEn = "Use 'Both' + plural noun + plural verb ('Both answers were...')."
        ),
        GrammarQuizQuestion(
            id = "q_u83_1",
            unitId = "u83_84",
            partId = "determiners",
            promptEn = "Let's hurry! We only have ___ time before the train leaves.",
            promptAr = "اختر أداة الكمية الصحيحة مع غير المعدود:",
            options = listOf("a few", "few", "a little", "many"),
            correctIndex = 2,
            explanationAr = "كلمة time غير معدودة، فنستخدم معها a little (وليس a few).",
            explanationEn = "'time' is uncountable, so use 'a little' (not 'a few')."
        ),
        GrammarQuizQuestion(
            id = "q_u83_2",
            unitId = "u83_84",
            partId = "determiners",
            promptEn = "Were there ___ people at the concert?",
            promptAr = "اختر أداة الكمية الصحيحة مع الجمع المعدود (people):",
            options = listOf("much", "a little", "many", "little"),
            correctIndex = 2,
            explanationAr = "people جمع معدود، لذلك نسأل بـ many وليس much.",
            explanationEn = "'people' is plural countable, so use 'many' in questions."
        ),

        // Part 16: Adjectives & Adverbs (6 questions - 2 per unit)
        GrammarQuizQuestion(
            id = "q_u85_1",
            unitId = "u85_86",
            partId = "adjectives_adverbs",
            promptEn = "She speaks French very ___.",
            promptAr = "اختر الظرف الصحيح لوصف الفعل speaks:",
            options = listOf("good", "well", "goodly", "best"),
            correctIndex = 1,
            explanationAr = "good صفة للاسم، أما الظرف الذي يصف الفعل فهو well.",
            explanationEn = "'well' is the adverb form of 'good' and modifies the verb 'speaks'."
        ),
        GrammarQuizQuestion(
            id = "q_u85_2",
            unitId = "u85_86",
            partId = "adjectives_adverbs",
            promptEn = "That soup smells ___! What's in it?",
            promptAr = "اختر الصفة المناسبة بعد فعل الحواس smell:",
            options = listOf("wonderfully", "wonderful", "well good", "nicely"),
            correctIndex = 1,
            explanationAr = "بعد أفعال الحواس والربط (smell, taste, look, feel, sound) نستخدم الصفة وليس الظرف.",
            explanationEn = "Linking verbs like 'smell' and 'look' take an adjective ('wonderful'), not an adverb."
        ),
        GrammarQuizQuestion(
            id = "q_u87_1",
            unitId = "u87_90",
            partId = "adjectives_adverbs",
            promptEn = "Mount Everest is the highest mountain ___ the world.",
            promptAr = "اختر حرف الجر الصحيح مع المكان بعد صيغة التفضيل:",
            options = listOf("of", "in", "on", "at"),
            correctIndex = 1,
            explanationAr = "بعد صيغ التفضيل (the highest / the best) ومع الأماكن نستخدم in وليس of.",
            explanationEn = "Use 'in' (not 'of') with places after superlatives: 'in the world'."
        ),
        GrammarQuizQuestion(
            id = "q_u87_2",
            unitId = "u87_90",
            partId = "adjectives_adverbs",
            promptEn = "This hotel is much ___ than the one we stayed in last year.",
            promptAr = "اختر صيغة المقارنة الصحيحة لصفة طويلة:",
            options = listOf("expensiver", "more expensive", "most expensive", "as expensive"),
            correctIndex = 1,
            explanationAr = "الصفة الطويلة expensive تأخذ more قبلها في المقارنة مع than.",
            explanationEn = "Multi-syllable adjectives form comparatives with 'more + adj + than'."
        ),
        GrammarQuizQuestion(
            id = "q_u91_1",
            unitId = "u91_92",
            partId = "adjectives_adverbs",
            promptEn = "We couldn't buy the car because we didn't have ___.",
            promptAr = "اختر الترتيب الصحيح لكلمة enough:",
            options = listOf("money enough", "enough money", "too money", "enough of money"),
            correctIndex = 1,
            explanationAr = "تأتي enough دائماً قبل الاسم (enough money) وبعد الصفة (old enough).",
            explanationEn = "'enough' goes BEFORE nouns ('enough money') and AFTER adjectives ('old enough')."
        ),
        GrammarQuizQuestion(
            id = "q_u91_2",
            unitId = "u91_92",
            partId = "adjectives_adverbs",
            promptEn = "The music is ___ loud. Please turn it down!",
            promptAr = "اختر الكلمة المناسبة قبل الصفة للدلالة على الزيادة المفرطة:",
            options = listOf("too much", "enough", "too", "many"),
            correctIndex = 2,
            explanationAr = "قبل الصفة (loud) نستخدم too فقط بدون much.",
            explanationEn = "Use 'too' (not 'too much') directly before adjectives like 'loud'."
        ),

        // Part 17: Word Order, Conjunctions & Conditionals (5 questions)
        GrammarQuizQuestion(
            id = "q_u93_1",
            unitId = "u93_96",
            partId = "word_order_clauses",
            promptEn = "That's my book. Please give ___.",
            promptAr = "اختر الترتيب الصحيح مع الضمير it:",
            options = listOf("to me it", "it to me", "me it to", "it me"),
            correctIndex = 1,
            explanationAr = "عند وجود ضمير كشيء (it) نضعه أولاً ثم to + الشخص: give it to me.",
            explanationEn = "When the direct object is a pronoun ('it'), use 'give it to me'."
        ),
        GrammarQuizQuestion(
            id = "q_u93_2",
            unitId = "u93_96",
            partId = "word_order_clauses",
            promptEn = "Which sentence has the correct English word order?",
            promptAr = "اختر الجملة ذات الترتيب الصحيح:",
            options = listOf(
                "I like very much Italian food.",
                "I like Italian food very much.",
                "I very much Italian food like.",
                "Like I Italian food very much."
            ),
            correctIndex = 1,
            explanationAr = "لا نفصل الفعل عن المفعول به أبداً؛ يأتي المفعول به (Italian food) مباشرة بعد الفعل.",
            explanationEn = "Keep verb + object together: 'I like Italian food very much'."
        ),
        GrammarQuizQuestion(
            id = "q_u97_1",
            unitId = "u97_100",
            partId = "word_order_clauses",
            promptEn = "I'll text you as soon as I ___ home.",
            promptAr = "اختر الزمن الصحيح بعد as soon as للمستقبل:",
            options = listOf("will get", "got", "get", "getting"),
            correctIndex = 2,
            explanationAr = "بعد الروابط الزمنية (when, if, as soon as, before) للمستقبل نستخدم المضارع البسيط.",
            explanationEn = "Use Present Simple ('get') after 'as soon as / when / if' when referring to the future."
        ),
        GrammarQuizQuestion(
            id = "q_u97_2",
            unitId = "u97_100",
            partId = "word_order_clauses",
            promptEn = "If I ___ his phone number, I would call him right now.",
            promptAr = "أكمل الشرطية الثانية (تخيل غير حقيقي الآن):",
            options = listOf("know", "knew", "would know", "have known"),
            correctIndex = 1,
            explanationAr = "في الجملة الشرطية الثانية التخيلية نستخدم الماضي البسيط (knew) بعد if، و would في الجواب.",
            explanationEn = "2nd Conditional uses Past Simple ('knew') in the if-clause for unreal present situations."
        ),
        GrammarQuizQuestion(
            id = "q_u97_3",
            unitId = "u97_100",
            partId = "word_order_clauses",
            promptEn = "If we ___ the bus, it will be much cheaper than a taxi.",
            promptAr = "أكمل الشرطية الأولى (احتمال واقعي):",
            options = listOf("took", "take", "will take", "would take"),
            correctIndex = 1,
            explanationAr = "في الشرطية الأولى نستخدم المضارع البسيط (take) بعد if وليس will.",
            explanationEn = "1st Conditional uses Present Simple ('take') in the if-clause."
        ),

        // Part 18: Relative Clauses (4 questions)
        GrammarQuizQuestion(
            id = "q_u101_1",
            unitId = "u101_102",
            partId = "relative_clauses",
            promptEn = "The woman ___ lives next door is an architect.",
            promptAr = "اختر ضمير الوصل المناسب للأشخاص:",
            options = listOf("which", "who", "what", "whom she"),
            correctIndex = 1,
            explanationAr = "للإشارة للأشخاص نستخدم who أو that بدون تكرار الضمير (she).",
            explanationEn = "Use 'who' (or 'that') for people, without adding an extra subject pronoun."
        ),
        GrammarQuizQuestion(
            id = "q_u101_2",
            unitId = "u101_102",
            partId = "relative_clauses",
            promptEn = "Have you found the keys ___ you lost yesterday?",
            promptAr = "اختر جملة الوصل الصحيحة للأشياء:",
            options = listOf("who", "that", "which them", "what"),
            correctIndex = 1,
            explanationAr = "للأشياء نستخدم that أو which (ويمكن حذفهما هنا) بدون إضافة them في النهاية.",
            explanationEn = "Use 'that' or 'which' for things (or omit it here since 'you' is the subject)."
        ),
        GrammarQuizQuestion(
            id = "q_u101_3",
            unitId = "u101_102",
            partId = "relative_clauses",
            promptEn = "Which sentence is grammatically correct?",
            promptAr = "اختر الجملة الخالية من خطأ تكرار الضمير:",
            options = listOf(
                "The book that I bought it is great.",
                "The book I bought is great.",
                "The book who I bought is great.",
                "The book what I bought is great."
            ),
            correctIndex = 1,
            explanationAr = "يجوز حذف that/which عندما تكون مفعولاً به، ولا نضيف it أبداً في نهاية جملة الوصل.",
            explanationEn = "You can omit the object relative pronoun ('The book I bought...'), and never add 'it'."
        ),
        GrammarQuizQuestion(
            id = "q_u101_4",
            unitId = "u101_102",
            partId = "relative_clauses",
            promptEn = "What's the name of the hotel ___ you stayed at?",
            promptAr = "اختر ضمير الوصل المناسب للشيء أو المكان كاسم:",
            options = listOf("who", "which", "whom", "whose"),
            correctIndex = 1,
            explanationAr = "بما أن حرف الجر at موجود في النهاية، نشير إلى hotel بـ which أو that (أو نحذفها).",
            explanationEn = "Use 'which' (or 'that') for things/buildings when the preposition stays at the end."
        ),

        // Part 19: Prepositions & Phrasal Verbs (8 questions - 2 per unit)
        GrammarQuizQuestion(
            id = "q_u103_1",
            unitId = "u103_105",
            partId = "prepositions_phrasal",
            promptEn = "The exam is ___ Friday morning ___ 9:30.",
            promptAr = "اختر حروف الجر الصحيحة لليوم والساعة:",
            options = listOf("in / at", "on / at", "at / on", "on / in"),
            correctIndex = 1,
            explanationAr = "مع الأيام وأجزاء اليوم المحددة بيوم (Friday morning) نستخدم on، ومع الساعة الدقيقة نستخدم at.",
            explanationEn = "Use 'on' for days/day-parts ('on Friday morning') and 'at' for clock times ('at 9:30')."
        ),
        GrammarQuizQuestion(
            id = "q_u103_2",
            unitId = "u103_105",
            partId = "prepositions_phrasal",
            promptEn = "Nobody spoke ___ the film.",
            promptAr = "اختر بين during و while قبل الاسم (the film):",
            options = listOf("while", "during", "until", "for"),
            correctIndex = 1,
            explanationAr = "during يأتي بعدها اسم (during the film)، بينما while يأتي بعدها جملة (فاعل وفعل).",
            explanationEn = "Use 'during' + noun ('during the film'), and 'while' + subject + verb."
        ),
        GrammarQuizQuestion(
            id = "q_u106_1",
            unitId = "u106_110",
            partId = "prepositions_phrasal",
            promptEn = "What time did your flight arrive ___ London?",
            promptAr = "اختر حرف الجر الصحيح مع arrive والمدن:",
            options = listOf("to", "in", "on", "for"),
            correctIndex = 1,
            explanationAr = "لا نستخدم to بعد arrive أبداً؛ نقول arrive IN للمدن والدول و arrive AT للمباني والمحطات.",
            explanationEn = "Never say 'arrive to'. Use 'arrive in' for cities/countries and 'arrive at' for stations/buildings."
        ),
        GrammarQuizQuestion(
            id = "q_u106_2",
            unitId = "u106_110",
            partId = "prepositions_phrasal",
            promptEn = "There is a mirror ___ the wall in the bathroom.",
            promptAr = "اختر حرف الجر المناسب للأسطح والجدران:",
            options = listOf("in", "at", "on", "to"),
            correctIndex = 2,
            explanationAr = "للأسطح والجدران والصفحات والطوابق نستخدم on دائماً.",
            explanationEn = "Use 'on' for surfaces like walls, tables, floors, and ceilings."
        ),
        GrammarQuizQuestion(
            id = "q_u111_1",
            unitId = "u111_113",
            partId = "prepositions_phrasal",
            promptEn = "Are you interested ___ learning Spanish?",
            promptAr = "اختر حرف الجر الثابت بعد interested:",
            options = listOf("at", "on", "in", "with"),
            correctIndex = 2,
            explanationAr = "الصفة interested تأخذ دائماً حرف الجر in ويتبعها V-ing.",
            explanationEn = "Always say 'interested in' (+ -ing or noun)."
        ),
        GrammarQuizQuestion(
            id = "q_u111_2",
            unitId = "u111_113",
            partId = "prepositions_phrasal",
            promptEn = "Don't forget to ___ me when you get home!",
            promptAr = "انتبه للأفعال التي لا تأخذ حرف جر في الإنجليزية:",
            options = listOf("phone to", "call to", "phone", "answer to"),
            correctIndex = 2,
            explanationAr = "الأفعال phone / call / thank / answer تأخذ المفعول مباشرة بدون to.",
            explanationEn = "'phone', 'call', 'thank', and 'answer' take a direct object with NO 'to'."
        ),
        GrammarQuizQuestion(
            id = "q_u114_1",
            unitId = "u114_115",
            partId = "prepositions_phrasal",
            promptEn = "Your coat is on the floor. Please ___.",
            promptAr = "اختر ترتيب الفعل المركب الصحيح مع الضمير it:",
            options = listOf("pick up it", "pick it up", "it pick up", "pick up"),
            correctIndex = 1,
            explanationAr = "عندما يكون المفعول به ضميراً (it / them) نضعه دائماً بين الفعل وحرف الجر: pick it up.",
            explanationEn = "When the object is a pronoun ('it'), it must go between the verb and particle: 'pick it up'."
        ),
        GrammarQuizQuestion(
            id = "q_u114_2",
            unitId = "u114_115",
            partId = "prepositions_phrasal",
            promptEn = "I'm sorry we're late. Our car ___ on the way here.",
            promptAr = "اختر الفعل المركب بمعنى 'تعطلت السيارة':",
            options = listOf("took off", "broke down", "gave up", "put on"),
            correctIndex = 1,
            explanationAr = "break down يُستخدم لتعطل السيارات والآلات (الماضي: broke down).",
            explanationEn = "'break down' (past: 'broke down') means a vehicle or machine stopped working."
        ),

        // Part 20: Appendices (6 questions - 2 per appendix)
        GrammarQuizQuestion(
            id = "q_app_1",
            unitId = "app_1_3",
            partId = "appendices",
            promptEn = "Someone has ___ my bicycle!",
            promptAr = "اختر التصريف الثالث الصحيح للفعل steal:",
            options = listOf("stole", "stealed", "stolen", "stealing"),
            correctIndex = 2,
            explanationAr = "التصريفات الثلاثة للفعل هي: steal - stole - stolen، وبعد has نستخدم التصريف الثالث (stolen).",
            explanationEn = "The irregular forms are steal - stole - stolen; use V3 ('stolen') after 'has'."
        ),
        GrammarQuizQuestion(
            id = "q_app_2",
            unitId = "app_1_3",
            partId = "appendices",
            promptEn = "Have you ___ the water yet? No, I haven't drunk any.",
            promptAr = "اختر التصريف الثالث الصحيح للفعل drink:",
            options = listOf("drank", "drunk", "drinked", "drinking"),
            correctIndex = 1,
            explanationAr = "يتبع النمط (i - a - u): drink - drank - drunk.",
            explanationEn = "Follows the i-a-u pattern: drink - drank - drunk."
        ),
        GrammarQuizQuestion(
            id = "q_app_3",
            unitId = "app_4_5",
            partId = "appendices",
            promptEn = "Which spelling of the past tense of 'stop' is correct?",
            promptAr = "اختر الإملاء الصحيح للماضي من stop:",
            options = listOf("stoped", "stopped", "stoppied", "stoppd"),
            correctIndex = 1,
            explanationAr = "الكلمة أحادية المقطع وتنتهي بحرف ساكن مسبوق بعلة واحدة (CVC)، لذا نضاعف الحرف الأخير: stopped.",
            explanationEn = "Double the final consonant in 1-syllable CVC verbs: 'stop' -> 'stopped'."
        ),
        GrammarQuizQuestion(
            id = "q_app_4",
            unitId = "app_4_5",
            partId = "appendices",
            promptEn = "In 'He's already finished', what does 's stand for?",
            promptAr = "حدد معنى الاختصار 's في هذه الجملة:",
            options = listOf("is", "was", "has", "does"),
            correctIndex = 2,
            explanationAr = "بما أن بعدها التصريف الثالث (finished)، فإن 's هنا اختصار للفعل has.",
            explanationEn = "Before a past participle ('finished'), 's is short for 'has'."
        ),
        GrammarQuizQuestion(
            id = "q_app_5",
            unitId = "app_6_7",
            partId = "appendices",
            promptEn = "I'm really looking forward to ___ you next week.",
            promptAr = "اختر الصيغة الصحيحة بعد look forward to:",
            options = listOf("see", "saw", "seeing", "seen"),
            correctIndex = 2,
            explanationAr = "في تعبير look forward to تكون to حرف جر وليس مصدرية، لذا يتبعها V-ing دائماً.",
            explanationEn = "'to' in 'look forward to' is a preposition, so it must be followed by '-ing' ('seeing')."
        ),
        GrammarQuizQuestion(
            id = "q_app_6",
            unitId = "app_6_7",
            partId = "appendices",
            promptEn = "We ___ the bus outside the museum and walked home.",
            promptAr = "اختر الفعل المركب الصحيح للنزول من الحافلة:",
            options = listOf("got out", "got off", "got down", "took off"),
            correctIndex = 1,
            explanationAr = "للنزول من الحافلة والقطار والطائرة نستخدم get off (والماضي: got off).",
            explanationEn = "Use 'get off' (past: 'got off') for buses, trains, planes, and bikes."
        )
    )
}
