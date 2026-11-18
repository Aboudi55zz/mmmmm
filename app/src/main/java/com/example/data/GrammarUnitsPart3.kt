package com.example.data

import com.example.model.CommonMistake
import com.example.model.GrammarComparisonRow
import com.example.model.GrammarExample
import com.example.model.GrammarUnitSummary

object GrammarUnitsPart3 {
    val units: List<GrammarUnitSummary> = listOf(
        // PART 15: DETERMINERS & QUANTIFIERS (Units 76-84)
        GrammarUnitSummary(
            id = "u76_79",
            partId = "determiners",
            unitBadge = "Units 76–79",
            titleEn = "some/any, no/none & somebody/nothing/every",
            titleAr = "some/any و الكلمات المركبة (somebody / nothing / everywhere)",
            tldrAr = "some للإثبات والعرض، و any للنفي والسؤال؛ أما المركبات (-body/-one/-thing/-where) فتتبع نفس القواعد وتأخذ فعلاً مفرداً.",
            tldrEn = "'some' for positives/offers, 'any' for negatives/questions. Compounds (-body/-thing/-where) follow the same rule and take a singular verb.",
            formulaEn = "not + any = no + noun | everybody/nothing/anything + singular verb",
            keyPointsAr = listOf(
                "some في الإثبات والطلب المهذب (Can I have some water?)؛ و any في النفي والسؤال العادي.",
                "no + اسم = not any + اسم: I have no money = I don't have any money.",
                "none تأتي وحدها بدون اسم: How much money have you got? — None.",
                "everybody / everyone / everything / nothing تأخذ دائماً فعلاً مفرداً: Everybody is here. / Nothing was said."
            ),
            keyPointsEn = listOf(
                "'some' in positive statements & polite offers; 'any' in negatives and general questions.",
                "'no' + noun = 'not any'; 'none' stands alone without a noun.",
                "Indefinite pronouns (everyone, nobody, everything, anything) ALWAYS take a singular verb."
            ),
            examples = listOf(
                GrammarExample("Nobody knows what happened. (= Not anybody knows...)", "Nobody تأخذ فعلاً مفرداً مثبتاً (knows).", "'Nobody' takes a singular positive verb."),
                GrammarExample("Is there anything in the bag? — No, nothing.", "anything للسؤال و nothing للجواب المختصر.", "'anything' in question vs 'nothing' in short answer.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("People", "الأشخاص", "somebody / anybody / nobody / everybody", "Everyone was happy."),
                GrammarComparisonRow("Things", "الأشياء", "something / anything / nothing / everything", "I didn't say anything."),
                GrammarComparisonRow("Places", "الأماكن", "somewhere / anywhere / nowhere / everywhere", "Let's go somewhere quiet.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I didn't see nobody. / Everybody are ready.",
                    "I didn't see anybody. (or I saw nobody.) / Everybody is ready.",
                    "لا نجمع نفيين (didn't + nobody)، وكلمة everybody تأخذ فعلاً مفرداً (is).",
                    "Avoid double negatives, and always use a singular verb with 'everybody'."
                )
            ),
            murphyTipAr = "عند إضافة صفة بعد something/nothing/anything تأتي الصفة بعد الكلمة لا قبلها: something hot / nothing new!",
            murphyTipEn = "Adjectives come AFTER -thing/-body words: 'something cold', 'anything interesting'."
        ),
        GrammarUnitSummary(
            id = "u80_82",
            partId = "determiners",
            unitBadge = "Units 80–82",
            titleEn = "every/all, most/some & both/either/neither",
            titleAr = "التعميم والتخصيص (every / all / both / either / neither)",
            tldrAr = "every + مفرد، و all + جمع/غير معدود. وللحديث عن شيئين فقط نستخدم both (كلاهما) و either (أحدهما) و neither (لا هذا ولا ذاك).",
            tldrEn = "'every' + singular; 'all' + plural/uncountable. For TWO things only, use 'both', 'either' (one of two), or 'neither' (not one or the other).",
            formulaEn = "every + sg | both + plural | either / neither + singular (or 'of the' + plural)",
            keyPointsAr = listOf(
                "every day = كل يوم (الكل فرداً فرداً + مفرد) | all day = طوال اليوم (من الصباح للمساء).",
                "most people (عموماً بدون of) مقابل most of the people in this room (مجموعة محددة مع of the).",
                "both (كلاهما + فعل جمع): Both windows are open.",
                "either (أيهما/أحدهما) و neither (لا هذا ولا ذاك + فعل مفرد): Neither restaurant is expensive."
            ),
            keyPointsEn = listOf(
                "'every day' (each day) vs 'all day' (the whole day from start to finish).",
                "General: 'most students', 'some cars'. Specific: 'most of the students here', 'both of my brothers'.",
                "For 2 items: 'both + plural noun', 'either / neither + singular noun' (or 'neither of the + plural')."
            ),
            examples = listOf(
                GrammarExample("We can go to either restaurant. I don't mind.", "either بمعنى أيّ من الاثنين.", "'either' = one or the other of two."),
                GrammarExample("Both of my parents live in Alexandria.", "both للإشارة لاثنين معاً.", "'both' for two people together.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("all / every", "الكل", "all + plural | every + singular", "All cities / Every city"),
                GrammarComparisonRow("both", "كلاهما (2)", "both + plural noun", "Both answers are right."),
                GrammarComparisonRow("either/neither", "أحدهما/ولا واحد (2)", "either / neither + singular", "Neither key fits.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Most of people like music. / Every people need water.",
                    "Most people like music. / Everybody needs water.",
                    "لا نضع of بدون the/my/these، و every لا تأتي مع الجمع (people).",
                    "Say 'Most people' (no 'of' for general) and never use 'every' with plural 'people'."
                )
            ),
            murphyTipAr = "تذكّر ثنائية مورفي السهلة: all/most/some للثلاثة فأكثر، أما both/either/neither فللاثنين فقط!",
            murphyTipEn = "Two items ONLY -> both / either / neither. Three or more -> all / any / none."
        ),
        GrammarUnitSummary(
            id = "u83_84",
            partId = "determiners",
            unitBadge = "Units 83–84",
            titleEn = "much / many / a lot & (a) little / (a) few",
            titleAr = "الكميات الكثيرة والقليلة (much / many / little / few)",
            tldrAr = "many و few للمعدود الجمع، و much و little لغير المعدود، بينما a lot of تناسب الاثنين. وحرف (a) يحوّل المعنى من 'غير كافٍ' إلى 'قليل لكن يكفي'.",
            tldrEn = "'many/few' go with plural countables; 'much/little' with uncountables; 'a lot of' with both. Adding 'a' makes the tone positive (enough).",
            formulaEn = "many / a few + plural | much / a little + uncountable | a lot of + both",
            keyPointsAr = listOf(
                "في الجمل المثبتة نفضّل a lot of على much/many: We bought a lot of food (أفضل من much food).",
                "في السؤال والنفي نستخدم much و many بكثرة: How much time? / There aren't many hotels.",
                "a little (كمية قليلة إيجابية) vs little (قليل جداً بالكاد يوجد).",
                "a few (عدد قليل إيجابي) vs few (عدد قليل جداً سلبي)."
            ),
            keyPointsEn = listOf(
                "Use 'a lot of / lots of' in positive sentences; use 'much / many' especially in questions and negatives.",
                "'a little' = some (positive) vs 'little' = nearly nothing (negative).",
                "'a few' = some (positive) vs 'few' = nearly none (negative)."
            ),
            examples = listOf(
                GrammarExample("She speaks a little Spanish, so she can order food.", "a little = قليل لكنه مفيد وكافٍ.", "'a little' = enough to be useful."),
                GrammarExample("He has very few friends, so he often feels lonely.", "few بدون a تدل على النقص والندرة.", "'few' without 'a' feels negative.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Large", "كثير", "a lot of / many (pl) / much (unc)", "Did you take many photos?"),
                GrammarComparisonRow("Small (+)", "قليل كافٍ", "a few (pl) / a little (unc)", "I have a few days off."),
                GrammarComparisonRow("Small (-)", "نادر/ناقص", "few (pl) / little (unc)", "There is little hope.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "We don't have many time. / I have much friends.",
                    "We don't have much time. / I have a lot of (or many) friends.",
                    "time غير معدودة تأخذ much، و friends معدودة جمع تأخذ many أو a lot of.",
                    "Use 'much' with uncountable 'time' and 'many/a lot of' with countable 'friends'."
                )
            ),
            murphyTipAr = "حيلة مورفي الذهبية: في الجملة المثبتة العادية استخدم دائماً a lot of ولن تخطئ أبداً سواء كان الاسم معدوداً أم غير معدود!",
            murphyTipEn = "Safe bet in positive sentences: 'a lot of' works cleanly for BOTH countable and uncountable nouns."
        ),

        // PART 16: ADJECTIVES & ADVERBS (Units 85-92)
        GrammarUnitSummary(
            id = "u85_86",
            partId = "adjectives_adverbs",
            unitBadge = "Units 85–86",
            titleEn = "Adjectives vs Adverbs (quick vs quickly)",
            titleAr = "الفرق بين الصفة والظرف (good / well)",
            tldrAr = "الصفة تصف الاسم (وتأتي قبله أو بعد be/look/feel/sound)، أما الظرف (-ly) فيصف كيفية حدوث الفعل.",
            tldrEn = "Adjectives modify nouns (or follow be/look/feel/taste); adverbs (-ly) modify verbs to explain HOW an action happens.",
            formulaEn = "be/look/feel + adjective | verb + adverb (-ly) | good (adj) -> well (adv)",
            keyPointsAr = listOf(
                "الصفة تسبق الاسم: a quiet street، أو تأتي بعد أفعال الحواس والربط: You look tired / It smells good.",
                "الظرف ينتهي غالباً بـ -ly ويصف الفعل: He drove carefully / She spoke quietly.",
                "شواذ مهمة: good (صفة) -> well (ظرف)؛ بينما fast و hard و late و early تبقى كما هي صفة وظرفاً!",
                "تذكّر: hardly لا تعني 'بجد' بل تعني 'بالكاد / قليلاً جداً'."
            ),
            keyPointsEn = listOf(
                "Adjectives go before nouns or after linking verbs (be, look, feel, smell, sound, taste).",
                "Most adverbs add -ly (quick -> quickly, heavy -> heavily).",
                "Irregulars: 'good' -> 'well'; 'fast', 'hard', 'late', 'early' are both adjectives and adverbs."
            ),
            examples = listOf(
                GrammarExample("Your English is very good. You speak English very well.", "good صفة للاسم English، و well ظرف للفعل speak.", "'good' (adj) vs 'well' (adv)."),
                GrammarExample("Tom worked hard yesterday. (NOT hardly)", "hard = بجد؛ hardly = بالكاد.", "'hard' = with effort; 'hardly' = almost not.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Adjective", "صفة للاسم", "noun + be/look + adj", "She is a careful driver."),
                GrammarComparisonRow("Adverb", "ظرف للفعل", "verb + adj-ly", "She drives carefully."),
                GrammarComparisonRow("Same Form", "نفس الشكل", "fast / hard / late", "A fast train / It goes fast.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "They played very good today. / She looks happily.",
                    "They played very well today. / She looks happy.",
                    "مع الفعل played نستخدم الظرف well، وبعد look (بمعنى يبدو) نستخدم الصفة happy.",
                    "Use adverb 'well' with 'played'; use adjective 'happy' after 'looks'."
                )
            ),
            murphyTipAr = "انتبه! بعد أفعال الحواس (look, feel, sound, smell, taste) نضع صفة دائماً: That sounds wonderful (وليس wonderfully).",
            murphyTipEn = "Linking verbs (feel, look, sound, smell, taste) always take adjectives, never -ly adverbs."
        ),
        GrammarUnitSummary(
            id = "u87_90",
            partId = "adjectives_adverbs",
            unitBadge = "Units 87–90",
            titleEn = "Comparatives & Superlatives (-er/more, -est/most)",
            titleAr = "المقارنة والتفضيل (أكبر من / الأكبر)",
            tldrAr = "الصفات القصيرة تأخذ -er للمقارنة و the -est للتفضيل، والطويلة تأخذ more و the most، مع الانتباه لصيغة المساواة as...as.",
            tldrEn = "Short adjectives take -er / the -est; longer adjectives take more / the most. Use 'as + adj + as' for equality.",
            formulaEn = "adj-er / more + adj + than | the + adj-est / the most + adj | (not) as + adj + as",
            keyPointsAr = listOf(
                "مقطع واحد: cheap -> cheaper -> the cheapest (مضاعفة الحرف: big -> bigger, hot -> hotter).",
                "تنتهي بـ -y: easy -> easier -> the easiest | مقطعين فأكثر: interesting -> more interesting -> the most interesting.",
                "شواذ أساسية: good -> better -> the best | bad -> worse -> the worst | far -> further -> the furthest.",
                "بعد than أو as...as نستخدم ضمير المفعول في المحادثة: She is taller than me (أو than I am)."
            ),
            keyPointsEn = listOf(
                "1-syllable & -y adjectives: -er / the -est (nice -> nicer, happy -> happier).",
                "2+ syllables: more / the most (more modern, the most expensive).",
                "Irregulars: good-better-best, bad-worse-worst, far-further-furthest.",
                "Use 'in' for places after superlatives ('the tallest building in the world'), 'of' for time/groups."
            ),
            examples = listOf(
                GrammarExample("Rome is old, but Athens is older. Cairo is the oldest of the three.", "تدرج الصفة والمقارنة والتفضيل.", "Positive -> comparative -> superlative."),
                GrammarExample("My bag isn't as heavy as yours.", "نفي المساواة بـ not as... as.", "Inequality with 'not as ... as'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Short", "قصيرة", "-er than / the -est", "faster than / the fastest"),
                GrammarComparisonRow("Long", "طويلة", "more... than / the most...", "more useful / the most useful"),
                GrammarComparisonRow("Equal", "مساواة", "(not) as + adj + as", "as tall as my brother")
            ),
            mistakes = listOf(
                CommonMistake(
                    "He is more taller than me. / It's the best city of the world.",
                    "He is taller than me. / It's the best city in the world.",
                    "لا نجمع بين more و -er معاً، ومع الأماكن بعد التفضيل نستخدم in وليس of.",
                    "Never combine 'more' with '-er'; use 'in' (not 'of') with places after superlatives."
                )
            ),
            murphyTipAr = "مع التفضيل نضع دائماً the قبل الصفة، ومع الأماكن مثل (the world, my class, the country) نستخدم حرف الجر in!",
            murphyTipEn = "Remember: 'the best IN the world / IN the class', NOT 'of the world'."
        ),
        GrammarUnitSummary(
            id = "u91_92",
            partId = "adjectives_adverbs",
            unitBadge = "Units 91–92",
            titleEn = "enough and too",
            titleAr = "استخدام enough (بما يكفي) و too (أكثر من اللازم)",
            tldrAr = "enough تعني الكمية الكافية وتأتي قبل الاسم وبعد الصفة، بينما too تعني زيادة سلبية عن الحد المطلوب وتأتي قبل الصفة.",
            tldrEn = "'enough' means sufficient (placed BEFORE nouns, AFTER adjectives); 'too' means excessive/more than good (placed BEFORE adjectives).",
            formulaEn = "enough + noun | adj/adv + enough | too + adj/adv | too much/many + noun",
            keyPointsAr = listOf(
                "enough + اسم: We have enough money. / Is there enough sugar?",
                "صفة/ظرف + enough: He isn't old enough to drive. / You don't work fast enough.",
                "too + صفة (بمعنى سلبي = زائد عن اللزوم): These shoes are too small (= لا تناسبني).",
                "too much + غير معدود | too many + معدود جمع: There is too much salt / too many cars."
            ),
            keyPointsEn = listOf(
                "'enough' BEFORE nouns ('enough chairs'); AFTER adjectives/adverbs ('warm enough').",
                "'too' = more than needed/wanted (usually negative): 'It's too loud.'",
                "Use 'too much' with uncountables and 'too many' with plural countables.",
                "Pattern: 'too + adj + for someone + to do' ('It's too heavy for me to carry')."
            ),
            examples = listOf(
                GrammarExample("The coffee is too hot to drink. / The water isn't warm enough to swim.", "توضيح الفرق بين too (أكثر من اللازم) و not enough (غير كافٍ).", "'too hot' vs 'not warm enough'."),
                GrammarExample("There are too many people and not enough seats.", "too many + معدود جمع، و enough + اسم.", "'too many' + plural vs 'enough' + noun.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("enough + N", "قبل الاسم", "enough + noun", "Do we have enough time?"),
                GrammarComparisonRow("Adj + enough", "بعد الصفة", "adj + enough + (to V1)", "Is your room big enough?"),
                GrammarComparisonRow("too + Adj", "قبل الصفة", "too + adj + (to V1)", "It's too late to go out.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "She isn't enough old. / It's too much cold today.",
                    "She isn't old enough. / It's too cold today.",
                    "enough تأتي بعد الصفة، وقبل الصفة نستخدم too فقط بدون much.",
                    "'enough' follows adjectives; use 'too' (NOT 'too much') directly before adjectives."
                )
            ),
            murphyTipAr = "أسهل مقارنة في مورفي: too تعني 'أكثر من المطلوب'، أما very فتعني 'جداً' فقط! (I'm very happy ✓ لكن NOT too happy إلا لو أردت معنى سلبياً).",
            murphyTipEn = "'very' is neutral/positive ('very nice'); 'too' implies a problem ('too expensive to buy')."
        ),

        // PART 17: WORD ORDER, CONJUNCTIONS & CONDITIONALS (Units 93-100)
        GrammarUnitSummary(
            id = "u93_96",
            partId = "word_order_clauses",
            unitBadge = "Units 93–96",
            titleEn = "Word Order, still/yet/already & Two-Object Verbs",
            titleAr = "ترتيب الجملة، still/yet/already والأفعال ذات المفعولين",
            tldrAr = "في الإنجليزية يلتصق المفعول به بالفعل مباشرة، ويسبق المكان الزمان، كما تأخذ ظروف مثل still و already مواقع ثابتة.",
            tldrEn = "Keep Verb + Object together, put Place before Time, place mid-position adverbs carefully, and master 'give me X' vs 'give X to me'.",
            formulaEn = "V + Object + Place + Time | give + person + thing = give + thing + to + person",
            keyPointsAr = listOf(
                "الفعل + المفعول لا ينفصلان: She speaks Italian very well (وليس speaks very well Italian).",
                "المكان قبل الزمان: Ben walked to work (مكان) this morning (زمان).",
                "always / also / already / still تأتي قبل الفعل الرئيسي وبعد am/is/are/can/have.",
                "still (ما زال - غالباً في الإثبات) vs yet (حتى الآن - في آخر النفي والسؤال) vs anymore/any longer (لم يعد)."
            ),
            keyPointsEn = listOf(
                "Never put adverbs between verb and object: 'I like pizza very much.'",
                "Place before Time: 'We arrived at the hotel at midnight.'",
                "'still' = continuing (before main verb / after 'be'); 'yet' = until now (end of neg/question).",
                "Two objects: 'I gave Sarah the keys' OR 'I gave the keys to Sarah' (use 'to/for' when thing comes first)."
            ),
            examples = listOf(
                GrammarExample("Are you still working? — No, I've already finished.", "still قبل الفعل الرئيسي و already بعد have.", "'still' and 'already' mid-position."),
                GrammarExample("Please pass me the salt. = Please pass the salt to me.", "حالتا المفعولين مع pass/give/send/show.", "Two ways to order indirect objects.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Place + Time", "مكان ثم زمان", "V + Obj + Place + Time", "I'm going to London on Monday."),
                GrammarComparisonRow("Mid Adverbs", "ظروف الوسط", "before V1 | after be/aux", "He is still here / He still works."),
                GrammarComparisonRow("2 Objects", "مفعولان", "V + person + thing / thing + to + person", "Send it to me.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I gave to her my phone number.",
                    "I gave her my phone number. / I gave my phone number to her.",
                    "إذا جاء الشخص بعد give مباشرة لا نضع to.",
                    "Do not put 'to' before the person when the person comes first."
                )
            ),
            murphyTipAr = "مع الضمائر (it / them) كشيء: نقول دائماً Give it to me (الشيء أولاً ثم to me) لأنها أخف وأفصح في النطق من Give me it.",
            murphyTipEn = "When the thing is a pronoun ('it/them'), always put it first: 'Give it to me', 'Send them to her'."
        ),
        GrammarUnitSummary(
            id = "u97_100",
            partId = "word_order_clauses",
            unitBadge = "Units 97–100",
            titleEn = "Conjunctions (and/but/so/because) & Conditionals (If)",
            titleAr = "أدوات الربط والجمل الشرطية (If 1 & 2)",
            tldrAr = "بعد الروابط الزمنية و if في الشرط الواقعي نستخدم المضارع البسيط للإشارة إلى المستقبل، أما في التخيل غير الحقيقي فنستخدم الماضي + would.",
            tldrEn = "Use Present Simple after when/before/until/if for future meaning. Use 'If + Past, would + V1' for imaginary present situations.",
            formulaEn = "When/If + Present, will + V1 | If + Past (V2), would + V1",
            keyPointsAr = listOf(
                "so = لذلك (النتيجة): It was hot, so I opened the window. | because = لأن (السبب): I opened it because it was hot.",
                "بعد when / while / before / after / until للمستقبل نستخدم المضارع البسيط (بدون will): I'll call you when I get home.",
                "الشرطية الأولى (حقيقي محتمل): If we take the bus, it will be cheaper.",
                "الشرطية الثانية (تخيّل غير حقيقي الآن): If I knew his number, I would phone him. (ومع be يصح If I were you)."
            ),
            keyPointsEn = listOf(
                "'so' introduces a result; 'because' introduces a reason; 'although' introduces contrast.",
                "Future time clauses: 'Wait here until I come back' (Present Simple after 'until/when/before').",
                "1st Conditional (real possibility): 'If it rains, we'll stay inside.'",
                "2nd Conditional (imaginary/unlikely now): 'If I had more time, I'd learn Spanish.'"
            ),
            examples = listOf(
                GrammarExample("If I see Ann tomorrow, I'll give her your message.", "احتمال واقعي غداً (مضارع بسيط + will).", "Real future condition."),
                GrammarExample("If I won a million pounds, I wouldn't work.", "تخيل غير واقعي حالياً (ماضي بسيط + would).", "Imaginary condition.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Time Clause", "رابط زمني", "when/before/until + Present", "Call me when you arrive."),
                GrammarComparisonRow("1st Cond.", "شرط واقعي", "If + Present, will + V1", "If you hurry, you'll make it."),
                GrammarComparisonRow("2nd Cond.", "شرط تخيلي", "If + Past (V2), would + V1", "If I were you, I'd go.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "If I will see him tomorrow, I'll tell him.",
                    "If I see him tomorrow, I'll tell him.",
                    "لا نضع will في جملة الشرط (بعد if أو when) أبداً!",
                    "Never put 'will' inside the 'if' or 'when' clause for standard future conditions."
                )
            ),
            murphyTipAr = "لإعطاء النصيحة بأسلوب راقٍ احفظ عبارة مورفي: If I were you, I would... (لو كنتُ مكانك لفعلت...).",
            murphyTipEn = "Remember: 'If I were you, I'd...' is the standard English pattern for giving personal advice."
        ),

        // PART 18: RELATIVE CLAUSES (Units 101-102)
        GrammarUnitSummary(
            id = "u101_102",
            partId = "relative_clauses",
            unitBadge = "Units 101–102",
            titleEn = "Relative Clauses (who / that / which)",
            titleAr = "جمل الوصل (الذي / التي) ومتى نحذف الضمير",
            tldrAr = "نستخدم who للأشخاص و which للأشياء و that لكليهما. ويمكن حذف الضمير تماماً إذا كان يحل محل المفعول به!",
            tldrEn = "Use 'who' for people, 'which' for things, and 'that' for either. You can omit who/that/which when it is the object of the clause.",
            formulaEn = "who/that (people) | which/that (things) | (omit when followed by Subject + Verb)",
            keyPointsAr = listOf(
                "للوصف عن الأشخاص: The woman who lives next door is a doctor. (أو that).",
                "للوصف عن الأشياء: Where is the cheese which/that was in the fridge?",
                "لا نحذف الضمير إذا جاء بعده فعل مباشرة (لأنه الفاعل): The man who phoned didn't give his name.",
                "يجوز حذف who/that/which إذا جاء بعدها فاعل + فعل (لأنه المفعول): The dress (that) Lisa bought is lovely."
            ),
            keyPointsEn = listOf(
                "'who' = people; 'which' = things; 'that' = people or things.",
                "Subject relative pronoun (KEEP IT): 'The people who work here are friendly.'",
                "Object relative pronoun (CAN OMIT): 'The people (who) we met were friendly.'",
                "Preposition stays at the end: 'The hotel (that) we stayed at was clean.'"
            ),
            examples = listOf(
                GrammarExample("Do you know the people who live here? (keep 'who')", "بعد who جاء فعل مباشرة (live) فلا يُحذف.", "Subject pronoun cannot be omitted."),
                GrammarExample("The books (that) I bought yesterday were cheap. (can omit)", "بعد that جاء فاعل (I) فيجوز حذفها.", "Object pronoun can be omitted.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("People", "الأشخاص", "who / that", "A doctor is someone who helps people."),
                GrammarComparisonRow("Things", "الأشياء", "which / that", "A key is a thing that opens a door."),
                GrammarComparisonRow("Omission", "حذف الضمير", "noun + (that) + S + V", "The film we saw was great.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "The man who he lives next door is friendly.",
                    "The man who lives next door is friendly.",
                    "لا نكرر الضمير (he / it / them) بعد who أو which في جملة الوصل!",
                    "Never add an extra pronoun ('he/it') after 'who/which/that' in a relative clause."
                )
            ),
            murphyTipAr = "أشهر خطأ عند متعلمي العربية هو إضافة 'it' أو 'him' في نهاية جملة الوصل مثل: the book that I read it ✗ -> الصحيح: the book that I read ✓.",
            murphyTipEn = "Common trap: never repeat the object pronoun at the end ('the movie I watched it' ✗ -> 'the movie I watched' ✓)."
        )
    )
}
