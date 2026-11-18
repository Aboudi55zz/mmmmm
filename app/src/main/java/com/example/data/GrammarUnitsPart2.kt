package com.example.data

import com.example.model.CommonMistake
import com.example.model.GrammarComparisonRow
import com.example.model.GrammarExample
import com.example.model.GrammarUnitSummary

object GrammarUnitsPart2 {
    val units: List<GrammarUnitSummary> = listOf(
        // PART 9: AUXILIARY VERBS
        GrammarUnitSummary(
            id = "u40_43",
            partId = "auxiliaries",
            unitBadge = "Units 40–43",
            titleEn = "Short Answers, Question Tags & So / Neither",
            titleAr = "الردود القصيرة والأسئلة الذيلية والموافقة",
            tldrAr = "تستخدم اللغة الإنجليزية الأفعال المساعدة (am, do, have, will, can) لتجنب التكرار وللموافقة باستخدام so / neither.",
            tldrEn = "Use auxiliaries to avoid repeating full verbs, confirm info with question tags, and agree using 'so' or 'neither'.",
            formulaEn = "So + aux + I (positive agree) | Neither + aux + I (negative agree)",
            keyPointsAr = listOf(
                "للرد بالاهتمام/التعجب: You're late. — Oh, am I? / I bought a car. — Did you?",
                "السؤال الذيلي يعكس الإثبات والنفي: It's a nice day, isn't it? / You don't like coffee, do you?",
                "للموافقة على جملة مثبتة: I'm tired. — So am I. / I work hard. — So do I.",
                "للموافقة على جملة منفية: I can't drive. — Neither can I (= I can't either)."
            ),
            keyPointsEn = listOf(
                "Show interest: 'I've just seen Lisa.' — 'Oh, have you? How is she?'",
                "Question tags reverse polarity: positive statement -> negative tag, and vice versa.",
                "'So am I' / 'So do I' agrees with positive statements; 'Neither am I' / 'Neither do I' agrees with negative ones."
            ),
            examples = listOf(
                GrammarExample("You haven't seen Kate today, have you?", "سؤال ذيلي مثبت لأن الجملة منفية.", "Positive tag after negative statement."),
                GrammarExample("I love chocolate. — So do I!", "الموافقة على فعل مضارع بسيط باستخدام do.", "Agreeing with Present Simple using 'do'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Agree (+)", "موافقة مثبتة", "So + aux + I / Me too", "So have I."),
                GrammarComparisonRow("Agree (-)", "موافقة منفية", "Neither + aux + I", "Neither did I."),
                GrammarComparisonRow("Tag", "سؤال ذيلي", "statement, aux + pronoun?", "She lives here, doesn't she?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I don't like fish. — So don't I.",
                    "I don't like fish. — Neither do I.",
                    "للموافقة على النفي نستخدم Neither مع فعل مساعد مثبت (do)، وليس So.",
                    "Use 'Neither' + positive auxiliary to agree with a negative statement."
                )
            ),
            murphyTipAr = "انتبه! مع جملة فيها فعل عادي (مثل I work, She went) نستخدم do/does/did في So و Neither والسؤال الذيلي.",
            murphyTipEn = "If the statement has no auxiliary verb (e.g., 'I live in Rome'), use do/does/did in tags and 'So/Neither'."
        ),

        // PART 10: QUESTIONS & REPORTED SPEECH
        GrammarUnitSummary(
            id = "u44_48",
            partId = "questions_reported",
            unitBadge = "Units 44–48",
            titleEn = "Questions & Subject vs Object Questions",
            titleAr = "تركيب الأسئلة (الفاعل مقابل المفعول)",
            tldrAr = "في السؤال العادي نضع الفعل المساعد قبل الفاعل، لكن عندما نسأل عن الفاعل نفسه بـ Who/What لا نستخدم do/does/did.",
            tldrEn = "Normal questions put the auxiliary before the subject; when 'who/what' IS the subject, do not use do/does/did.",
            formulaEn = "Object Q: Wh- + aux + S + V? | Subject Q: Who/What + Verb?",
            keyPointsAr = listOf(
                "السؤال عن المفعول: Who did you see? (من رأيتَ؟) — استخدمنا did.",
                "السؤال عن الفاعل: Who saw you? (من رآكَ؟) — الفاعل مجهول لذا لا نستخدم did!",
                "حروف الجر في السؤال تأتي غالباً في النهاية: Who are you talking to? / Where are you from?",
                "في الأسئلة غير المباشرة (Do you know where...?) يعود الترتيب طبيعياً (فاعل ثم فعل): Do you know where Tom is?"
            ),
            keyPointsEn = listOf(
                "Object question: 'Who did Paul phone?' (Paul phoned someone).",
                "Subject question: 'Who phoned Paul?' (Someone phoned Paul — NO 'did').",
                "Prepositions usually stay at the end: 'What are you looking at?'",
                "Indirect questions keep statement word order: 'Do you know what time it is?' (NOT 'is it')."
            ),
            examples = listOf(
                GrammarExample("Who broke this window? (Subject = Who)", "Who هي الفاعل، فلا نضع did.", "Subject question without 'did'."),
                GrammarExample("Could you tell me where the station is?", "سؤال غير مباشر بترتيب الجملة العادية.", "Indirect question word order.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Subject Q", "سؤال عن الفاعل", "Who/What + Verb", "What happened?"),
                GrammarComparisonRow("Object Q", "سؤال عن المفعول", "Wh- + do/did + S + V1", "What did he say?"),
                GrammarComparisonRow("Indirect Q", "سؤال غير مباشر", "Do you know + Wh- + S + V", "Do you know where she lives?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Do you know where is the bank?",
                    "Do you know where the bank is?",
                    "بعد Do you know / Can you tell me نرتب الجملة كخبر (فاعل ثم فعل) وليس كسؤال.",
                    "In indirect questions, put the subject before the verb."
                )
            ),
            murphyTipAr = "اختبر نفسك في الأسئلة غير المباشرة: غطِّ Do you know ورتّب الباقي كجملة عادية: the bank is here!",
            murphyTipEn = "Rule of thumb for indirect questions: after 'Do you know where...', use normal statement order ('she went', not 'did she go')."
        ),
        GrammarUnitSummary(
            id = "u49_50",
            partId = "questions_reported",
            unitBadge = "Units 49–50",
            titleEn = "Reported Speech (He said that...)",
            titleAr = "الكلام المنقول (said / told)",
            tldrAr = "عند نقل كلام شخص قيل في الماضي، تتحول أفعال المضارع خطوة للوراء نحو الماضي، وننتبه للفرق بين say و tell.",
            tldrEn = "When reporting past speech, present verbs usually shift back into the past; remember 'say (to sb)' vs 'tell sb'.",
            formulaEn = "said (that) + past | told + someone + (that) + past",
            keyPointsAr = listOf(
                "am/is -> was | are -> were | do/does -> did | have/has -> had | will -> would | can -> could.",
                "say لا يأخذ مفعولاً مباشراً (أو يأخذ to): He said (that)... / He said to me...",
                "tell يجب أن يأخذ شخصاً بعده مباشرة بدون to: He told me (that)..."
            ),
            keyPointsEn = listOf(
                "Backshift tenses: am/is -> was, have -> had, will -> would, can -> could.",
                "'say' does not take a personal object directly (say something / say to me).",
                "'tell' MUST take a personal object (tell me / tell John something)."
            ),
            examples = listOf(
                GrammarExample("Direct: 'I am tired.' -> Reported: She said (that) she was tired.", "تحول am إلى was.", "Present 'am' shifts to 'was'."),
                GrammarExample("Jack told me that he couldn't come.", "told + me بدون حرف جر.", "'told me' with direct personal object.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("say", "يقول", "S + said (to me) that...", "She said she was busy."),
                GrammarComparisonRow("tell", "يخبر", "S + told + person + that...", "She told me she was busy.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "He told that he was ill.",
                    "He told me that he was ill. / He said that he was ill.",
                    "الفعل tell يحتاج شخصاً بعده مباشرة (told me)، وإلا نستخدم said.",
                    "'told' requires a listener (e.g., 'told me'); otherwise use 'said'."
                )
            ),
            murphyTipAr = "احفظ المعادلة السريعة: tell + شخص (بدون to)، أما say فبدون شخص (أو say to + شخص).",
            murphyTipEn = "Easy formula: 'tell SOMEBODY' (no 'to') vs 'say SOMETHING' (or 'say to somebody')."
        ),

        // PART 11: -ING AND TO...
        GrammarUnitSummary(
            id = "u51_54",
            partId = "ing_to",
            unitBadge = "Units 51–54",
            titleEn = "Verb + -ing vs Verb + to...",
            titleAr = "الأفعال المتبوعة بـ -ing أو to + المصدر",
            tldrAr = "بعض الأفعال تتطلب بعدها (to + V1) مثل want/decide/hope، وأخرى تتطلب (V-ing) مثل enjoy/mind/finish، وبعضها يقبل الاثنين.",
            tldrEn = "Some verbs take 'to + V1' (want, decide), some take 'V-ing' (enjoy, suggest, finish), and a few take both.",
            formulaEn = "enjoy/finish/mind + V-ing | want/decide/plan + to V1",
            keyPointsAr = listOf(
                "أفعال تتبعها -ing: enjoy, mind, stop, finish, suggest, keep.",
                "أفعال يتبعها to + المصدر: want, need, decide, hope, plan, promise, learn, forget.",
                "أفعال تقبل الاثنين بنفس المعنى تقريباً: like, love, hate, start, begin.",
                "بعد حروف الجر (in, on, at, for, before, after, without) نستخدم دائماً V-ing!",
                "للتعبير عن الغرض (لماذا؟): I went to the shop to buy milk (وليس for buying)."
            ),
            keyPointsEn = listOf(
                "Always + -ing: enjoy, mind, finish, stop, suggest, give up.",
                "Always + to V1: want, hope, decide, offer, promise, forget, learn.",
                "After ANY preposition (about, for, without, before), always use -ing.",
                "Purpose uses 'to + V1': 'I called to ask a question' (NOT 'for asking')."
            ),
            examples = listOf(
                GrammarExample("I enjoy reading, and I decided to buy a new book.", "enjoy + V-ing، و decide + to.", "enjoy + -ing vs decide + to."),
                GrammarExample("She left without saying goodbye.", "بعد حرف الجر without جاء الفعل بـ -ing.", "Preposition + -ing."),
                GrammarExample("I want you to help me.", "want + مفعول + to + المصدر (لا نستخدم that).", "'want someone to do', not 'that they do'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("+ V-ing", "فعل + ing", "enjoy / mind / finish + V-ing", "Would you mind closing it?"),
                GrammarComparisonRow("+ to V1", "فعل + to", "want / decide / hope + to V1", "I hope to see you soon."),
                GrammarComparisonRow("Prep + ing", "حرف جر", "for / before / without + V-ing", "Thanks for helping me.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I want that you come with me.",
                    "I want you to come with me.",
                    "لا نستخدم that بعد want! التركيب الصحيح: want + شخص + to + الفعل.",
                    "Never use 'that' after 'want'; say 'want someone to do something'."
                ),
                CommonMistake(
                    "I went to London for studying English.",
                    "I went to London to study English.",
                    "لبيان سبب القيام بالفعل نستخدم to + المصدر (to study) وليس for + ing.",
                    "Use 'to + verb' for purpose of an action, not 'for + -ing'."
                )
            ),
            murphyTipAr = "قاعدة ذهبية في كتاب مورفي: أي فعل يأتي مباشرة بعد حرف جر (مثل interested in, good at, without, before) يأخذ -ing بلا استثناء!",
            murphyTipEn = "100% reliable rule: any verb immediately following a preposition takes the -ing form."
        ),

        // PART 12: GO, GET, DO, MAKE, HAVE
        GrammarUnitSummary(
            id = "u55_58",
            partId = "go_get_do_make",
            unitBadge = "Units 55–58",
            titleEn = "go, get, do vs make & have",
            titleAr = "الفرق بين do و make واستخدامات go و get",
            tldrAr = "do ترتبط بالأعمال والأنشطة العامة، بينما make ترتبط بالإنتاج والإنشاء، و get تعني غالباً 'يصبح' أو 'يحصل على' أو 'يصل'.",
            tldrEn = "'do' is for general activities/tasks; 'make' is for creating/producing; 'get' means receive, buy, become, or arrive.",
            formulaEn = "do (work/homework/best) | make (coffee/mistake/decision) | get (+ adj = become)",
            keyPointsAr = listOf(
                "go + -ing للأنشطة والرياضات: go shopping, go swimming, go running, go skiing.",
                "get + اسم = يحصل على / يشتري (get a job, get an email) | get + صفة = يصبح (get tired, get dark, get married).",
                "do: do homework, do housework, do an exam, do the shopping, do your best.",
                "make: make a mistake, make coffee, make noise, make a decision, make friends, make a phone call."
            ),
            keyPointsEn = listOf(
                "'go + -ing' for leisure/sports: go shopping, go swimming, go fishing.",
                "'get' + noun = receive/buy; 'get' + adjective = become (get cold, get ready); 'get to' = arrive.",
                "'do' = tasks & work (do homework, do the dishes); 'make' = produce/create (make a cake, make a plan)."
            ),
            examples = listOf(
                GrammarExample("It's getting late. We need to go home.", "get + صفة بمعنى يصبح.", "get + adjective = become."),
                GrammarExample("I made a mistake in my homework, so I have to do it again.", "الفرق العملي بين make (أخطأ) و do (أداء الواجب).", "made a mistake vs do homework.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("do", "أداء عمل", "work, homework, exam, dishes", "She's doing an exam."),
                GrammarComparisonRow("make", "صنع/إنشاء", "mistake, noise, coffee, bed", "Don't make a noise."),
                GrammarComparisonRow("get", "حصول/تحول", "get + adj / get to + place", "What time did you get home?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I did a big mistake.",
                    "I made a big mistake.",
                    "نستخدم make مع mistake و decision و noise وليس do.",
                    "Always say 'make a mistake', never 'do a mistake'."
                )
            ),
            murphyTipAr = "مع home و here و there لا نضع to بعد go أو get: نقول go home و get home وليس go to home!",
            murphyTipEn = "Never put 'to' before home, here, or there: say 'go home' and 'get home'."
        ),

        // PART 13: PRONOUNS & POSSESSIVES
        GrammarUnitSummary(
            id = "u59_64",
            partId = "pronouns",
            unitBadge = "Units 59–64",
            titleEn = "Pronouns, Possessives & Reflexives",
            titleAr = "الضمائر وصفات وضمائر الملكية والملكية ('s)",
            tldrAr = "التمييز بين صفة الملكية (تُتبع باسم: my book) وضمير الملكية (يأتي وحده: It's mine)، والضمائر الانعكاسية (myself).",
            tldrEn = "Distinguish possessive adjectives (my + noun) from possessive pronouns (mine — no noun), reflexives (myself), and 's.",
            formulaEn = "I -> me -> my (+ noun) -> mine | myself | Tom's car",
            keyPointsAr = listOf(
                "my / your / his / her / our / their يأتي بعدها اسم دائماً: That's my phone.",
                "mine / yours / his / hers / ours / theirs تأتي بدون اسم بعدها: That phone is mine.",
                "الضمائر الانعكاسية (myself, yourself, himself, themselves) عندما يكون الفاعل والمفعول واحداً: I cut myself.",
                "للملكية مع الأشخاص نستخدم 's للمفرد (my sister's name) و s' للجمع (my parents' house)."
            ),
            keyPointsEn = listOf(
                "Possessive determiner + noun ('my bag') vs possessive pronoun alone ('It's mine').",
                "Reflexive pronouns (myself, ourselves): subject and object are the same person.",
                "by myself = alone; each other = reciprocal (Tom and Ann looked at each other).",
                "Use 's for people/animals (Sarah's brother), and 'of' for things (the roof of the house)."
            ),
            examples = listOf(
                GrammarExample("A friend of mine gave me this book.", "نستخدم mine بعد of (وليس my).", "'a friend of mine', not 'a friend of me'."),
                GrammarExample("They blamed themselves vs They blamed each other.", "themselves = كل شخص نفسه | each other = كل منهما الآخر.", "Reflexive vs reciprocal.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Subject/Object", "فاعل/مفعول", "I/me, he/him, they/them", "Give it to them."),
                GrammarComparisonRow("Possessive", "ملكية", "my + noun / mine (alone)", "Your car / Yours."),
                GrammarComparisonRow("Reflexive", "انعكاسي", "myself / herself / themselves", "Enjoy yourself!")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Whose bag is this? It's my.",
                    "Whose bag is this? It's mine.",
                    "بدون اسم بعد الضمير نستخدم mine وليس my.",
                    "Use 'mine' when no noun follows."
                )
            ),
            murphyTipAr = "ملاحظة مورفي المهمة: نستخدم 's للملكية مع الأشخاص والوقت (yesterday's newspaper, a week's holiday)، و of مع الجمادات (the door of the car).",
            murphyTipEn = "Use 's for people and time expressions ('today's news'), and 'of' for objects ('the end of the street')."
        ),

        // PART 14: A/AN, THE & NOUNS
        GrammarUnitSummary(
            id = "u65_68",
            partId = "articles_nouns",
            unitBadge = "Units 65–68",
            titleEn = "a/an, Plural & Countable/Uncountable",
            titleAr = "أدوات التنكير والأسماء المعدودة وغير المعدودة",
            tldrAr = "a/an تُستخدم مع المفرد المعدود فقط (a/an حسب الصوت لا الحرف)، والأسماء غير المعدودة لا تُجمع ولا تأخذ a/an.",
            tldrEn = "'a/an' is for singular countable nouns only (chosen by sound, not spelling). Uncountable nouns have no plural and never take 'a/an'.",
            formulaEn = "a + consonant sound | an + vowel sound | uncountable = singular verb",
            keyPointsAr = listOf(
                "نختار an حسب النطق الصوتي لحرف العلة: an hour (الـ h صامتة) لكن a university (تُنطق yoo).",
                "المهن تأخذ دائماً a/an: She is a doctor / He is an engineer.",
                "أسماء غير معدودة مهمة في الإنجليزية (تُعامل معاملة المفرد ولا تأخذ s أو a/an): information, advice, news, furniture, luggage, work, money, weather."
            ),
            keyPointsEn = listOf(
                "Sound matters: 'an umbrella', 'an hour' (silent h), but 'a university' (/ju:/ sound).",
                "Always use a/an with jobs: 'My brother is an architect.'",
                "Uncountable trap nouns in English: information, advice, news, furniture, luggage, bread, weather (NO plural -s, NO a/an)."
            ),
            examples = listOf(
                GrammarExample("The news was very good today.", "news غير معدودة وتأخذ فعلاً مفرداً (was).", "'news' is uncountable and singular."),
                GrammarExample("Can I give you some advice? (or a piece of advice)", "لا نقول an advice بل some advice.", "'advice' is uncountable.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("a / an", "مفرد نكرة", "a/an + singular countable", "an apple / a uniform"),
                GrammarComparisonRow("Uncountable", "غير معدود", "no a/an, no -s, singular V", "This furniture is new."),
                GrammarComparisonRow("Measure", "تجزئة", "a piece of / a cup of", "two pieces of advice")
            ),
            mistakes = listOf(
                CommonMistake(
                    "She gave me some good advices and informations.",
                    "She gave me some good advice and information.",
                    "advice و information أسماء غير معدودة في الإنجليزية فلا يُضاف لها s أبداً.",
                    "'advice' and 'information' are uncountable and never take -s."
                )
            ),
            murphyTipAr = "احذر من الكلمات الخادعة في مورفي: news (أخبار) تنتهي بـ s لكنها مفردة وغير معدودة! بينما police و people تُعامل جمعاً دائماً: The police are here.",
            murphyTipEn = "'news' ends in -s but is singular ('The news is...'); 'police' and 'people' are always plural ('The police are...')."
        ),
        GrammarUnitSummary(
            id = "u69_70",
            partId = "articles_nouns",
            unitBadge = "Units 69–70",
            titleEn = "Using 'the' vs Zero Article",
            titleAr = "متى نستخدم أداة التعريف the ومتى نحذفها",
            tldrAr = "نستخدم the عندما يعرف المستمع تحديداً أي شيء تقصده، ونحذفها عندما نتكلم عن الأشياء أو المفاهيم بشكل عام.",
            tldrEn = "Use 'the' when both speaker and listener know which specific thing is meant; omit 'the' when talking in general.",
            formulaEn = "Specific = the + noun | General = plural / uncountable (no 'the')",
            keyPointsAr = listOf(
                "ذكر للمرة الأولى (a/an) ثم تحديد (the): I bought a jacket and a shirt. The jacket was cheap.",
                "للحديث بشكل عام نحذف the: I like music (الموسيقى عموماً) vs Turn down the music (هذه الموسيقى الآن).",
                "نضع the مع الأشياء الفريدة في الكون: the sun, the moon, the sky, the internet, the capital."
            ),
            keyPointsEn = listOf(
                "First mention = a/an; second mention = the. Unique things = the sun, the sky, the internet.",
                "General ideas take NO 'the': 'Life is wonderful', 'Dogs are friendly.'",
                "Use 'the' when the listener knows exactly which one: 'Close the door, please.'"
            ),
            examples = listOf(
                GrammarExample("Children learn languages faster than adults.", "تعميم عام بدون the.", "General plural nouns without 'the'."),
                GrammarExample("The children are playing in the garden.", "أطفال محددون نعرفهم الآن.", "Specific children known to speaker.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("General", "تعميم", "No 'the' + plural/uncount", "I love coffee and books."),
                GrammarComparisonRow("Specific", "تخصيص", "the + noun", "The coffee in this cup is cold.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "The life is hard sometimes.",
                    "Life is hard sometimes.",
                    "عند الحديث عن الحياة أو الناس أو الطبيعة بشكل عام لا نضع the.",
                    "Omit 'the' when speaking about 'life', 'people', or 'nature' in general."
                )
            ),
            murphyTipAr = "قاعدة مورفي السريعة: اسأل نفسك 'أي واحد بالضبط؟' — إن كانت الإجابة محددة وواضحة للطرفين ضع the، وإن كنت تتحدث عن الصنف كله فاحذفها.",
            murphyTipEn = "Ask 'Which specific one?' If both speaker and listener know which one, use 'the'. If speaking generally, omit it."
        ),
        GrammarUnitSummary(
            id = "u71_73",
            partId = "articles_nouns",
            unitBadge = "Units 71–73",
            titleEn = "Places with/without 'the' (go to work, the Nile)",
            titleAr = "استخدام the مع الأماكن والدول والمعالم",
            tldrAr = "الأماكن الروتينية (work, school, bed, home) ومعظم الدول والمدن لا تأخذ the، بينما الدول المركبة والبحار والأنهار والآلات تأخذ the.",
            tldrEn = "Routine places (go to work/bed/home) and single countries/cities take no 'the'; plural countries, rivers, oceans, and hotels take 'the'.",
            formulaEn = "No 'the': go to work/bed/home, France | Use 'the': the USA, the Nile, the cinema",
            keyPointsAr = listOf(
                "بدون the للغرض المعتاد: go to work, go to school, in hospital (كمريض), at home, go to bed.",
                "مع the لأماكن الترفيه والخدمات العامة: go to the cinema, the theatre, the bank, the post office, the doctor.",
                "الدول المفردة والشوارع والقمم بدون the: Egypt, London, Oxford Street, Mount Everest.",
                "الدول بصيغة الجمع أو المركبة والبحار والأنهار تأخذ the: the USA, the UK, the Netherlands, the Red Sea, the Nile."
            ),
            keyPointsEn = listOf(
                "No 'the': go to work / school / university / church / bed / home.",
                "With 'the': go to the cinema / theatre / bank / airport / station.",
                "No 'the': continents, most countries (Japan), cities (Cairo), streets, single mountains (Mount Fuji).",
                "With 'the': plural/republic countries (the USA, the UAE), oceans, rivers, mountain ranges (the Alps)."
            ),
            examples = listOf(
                GrammarExample("What time do you go to bed? vs I'm going to the cinema tonight.", "bed بدون the، و cinema مع the.", "'to bed' vs 'to the cinema'."),
                GrammarExample("The Nile flows into the Mediterranean Sea.", "الأنهار والبحار تأخذ the دائماً.", "Rivers and seas take 'the'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("No 'the'", "بدون the", "work, school, home, France, Cairo", "She went home early."),
                GrammarComparisonRow("With 'the'", "مع the", "the cinema, the USA, the Alps", "Have you visited the UK?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I'm going to the home now. / She lives in USA.",
                    "I'm going home now. / She lives in the USA.",
                    "home لا تأخذ to ولا the، والدول المركبة مثل the USA و the UK تأخذ the.",
                    "Say 'go home' (no 'to the') and 'in the USA' (with 'the')."
                )
            ),
            murphyTipAr = "مع الكلمات (school / hospital / prison): إذا ذهبت للتعلّم أو العلاج فبدون the (in hospital)، وإذا ذهبت كزائر فقط فمع the (at the hospital).",
            murphyTipEn = "In British English: 'in hospital' = as a patient; 'at the hospital' = visiting someone."
        ),
        GrammarUnitSummary(
            id = "u74_75",
            partId = "articles_nouns",
            unitBadge = "Units 74–75",
            titleEn = "this/that/these/those & one/ones",
            titleAr = "أسماء الإشارة والبديل one / ones",
            tldrAr = "this/these للقريب و that/those للبعيد، ونستخدم one (للمفرد) و ones (للجمع) لتفادي تكرار الاسم.",
            tldrEn = "'this/these' = near; 'that/those' = far/past. Use 'one' (singular) and 'ones' (plural) to avoid repeating a countable noun.",
            formulaEn = "this/that + singular | these/those + plural | a + adj + one / the + adj + ones",
            keyPointsAr = listOf(
                "this (مفرد قريب) و these (جمع قريب) | that (مفرد بعيد) و those (جمع بعيد).",
                "تُستخدم أيضاً على الهاتف أو عند تقديم شخص: Hello, this is Sarah speaking.",
                "لتجنب تكرار الاسم المعدود المفرد نستخدم one: I need a pen. Have you got one? / Which one? The red one.",
                "للجمع نستخدم ones: Which shoes do you prefer, the black ones or the brown ones?"
            ),
            keyPointsEn = listOf(
                "'this/these' = here/now; 'that/those' = there/earlier.",
                "Replace a singular countable noun with 'one': 'I'd like a small one.'",
                "Replace a plural noun with 'ones': 'These cups are dirty. Let's use the clean ones.'"
            ),
            examples = listOf(
                GrammarExample("Do you like these shoes or those ones over there?", "these للقريب و those ones للبعيد.", "'these' (near) vs 'those ones' (far)."),
                GrammarExample("My car is old. I want to buy a new one.", "one عوضت عن تكرار كلمة car.", "'one' replaces 'car'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Near", "قريب", "this (sg) / these (pl)", "This apple / these apples"),
                GrammarComparisonRow("Far", "بعيد", "that (sg) / those (pl)", "That house / those houses"),
                GrammarComparisonRow("Substitute", "بديل الاسم", "a/the + adj + one / ones", "The blue one / the new ones")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Do you want the big bag or the small?",
                    "Do you want the big bag or the small one?",
                    "لا نترك الصفة وحدها بدون الاسم أو one في الإنجليزية.",
                    "Don't leave an adjective alone without a noun or 'one/ones'."
                )
            ),
            murphyTipAr = "لا تستخدم one/ones بدلاً من الأسماء غير المعدودة (مثل milk, money)! نقول: Do you want fresh milk? بدون one.",
            murphyTipEn = "Never use 'one' for uncountable nouns: say 'some cold water', NOT 'a cold one' (unless meaning a bottle/drink)."
        )
    )
}
