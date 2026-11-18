package com.example.data

import com.example.model.CommonMistake
import com.example.model.GrammarComparisonRow
import com.example.model.GrammarExample
import com.example.model.GrammarUnitSummary

object GrammarUnitsPart1 {
    val units: List<GrammarUnitSummary> = listOf(
        // PART 1: PRESENT TENSES
        GrammarUnitSummary(
            id = "u1_2",
            partId = "present",
            unitBadge = "Units 1–2",
            titleEn = "am / is / are (Verb to Be)",
            titleAr = "فعل الكينونة في المضارع (am / is / are)",
            tldrAr = "يُستخدم لوصف الحالة أو الصفة أو الوظيفة أو الموقع في الوقت الحاضر بدون فعل رئيسي آخر.",
            tldrEn = "Used to state identity, feelings, professions, or locations in the present without another main verb.",
            formulaEn = "I am | he/she/it is | we/you/they are",
            keyPointsAr = listOf(
                "نستخدم am مع I، و is مع المفرد (he/she/it)، و are مع الجمع و you.",
                "في المحادثة اليومية نستخدم الاختصارات دائماً: I'm, he's, they're.",
                "لتكوين السؤال نعكس ترتيب الفعل والفاعل: Is she at home? Are they ready?"
            ),
            keyPointsEn = listOf(
                "Use 'am' with I, 'is' with singular subjects, and 'are' with plural subjects & you.",
                "Contractions (I'm, she's, you're) are natural in everyday speech.",
                "For questions, invert subject and verb: 'Are you tired?' (not 'You are tired?')."
            ),
            examples = listOf(
                GrammarExample("I'm 22 years old. My sister is 29.", "لذكر العمر والوصف الشخصي.", "For stating age and personal facts."),
                GrammarExample("It's ten o'clock. You're late again.", "للتعبير عن الوقت والصفة.", "For time and condition."),
                GrammarExample("Are your shoes new? — Yes, they are.", "السؤال والجواب القصير بدون تكرار الجملة.", "Question and short answer.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Positive", "الإثبات", "Subject + am/is/are", "She is a doctor."),
                GrammarComparisonRow("Negative", "النفي", "Subject + am/is/are + not", "They aren't busy."),
                GrammarComparisonRow("Question", "السؤال", "Am/Is/Are + Subject?", "Am I late?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I am agree with you.",
                    "I agree with you.",
                    "agree فعل رئيسي لا يأخذ am/is/are قبلها في المضارع البسيط.",
                    "'Agree' is a main verb, so do not put 'am' before it."
                ),
                CommonMistake(
                    "Yes, I'm.",
                    "Yes, I am.",
                    "لا نختصر الفعل في الإجابة القصيرة المثبتة أبداً.",
                    "Never use a contraction in a positive short answer."
                )
            ),
            murphyTipAr = "تذكّر قاعدة مورفي الذهبية: في الإجابة القصيرة المثبتة نقول Yes, I am / Yes, he is بدون اختصار، أما في النفي فنختصر: No, I'm not.",
            murphyTipEn = "Murphy's Golden Rule: Positive short answers never contract (Yes, he is), while negative ones usually do (No, he isn't)."
        ),
        GrammarUnitSummary(
            id = "u3_4",
            partId = "present",
            unitBadge = "Units 3–4",
            titleEn = "Present Continuous (I am doing)",
            titleAr = "المضارع المستمر (am/is/are + V-ing)",
            tldrAr = "يصف حدثاً يقع الآن في لحظة الكلام أو مشروعاً مؤقتاً لم ينتهِ بعد.",
            tldrEn = "Describes an action happening right now at the moment of speaking or around now.",
            formulaEn = "Subject + am / is / are + Verb-ing",
            keyPointsAr = listOf(
                "نستخدمه لما يحدث الآن: Please be quiet. I'm working.",
                "يُستخدم للأحداث المؤقتة هذه الأيام: She's staying at a hotel this week.",
                "انتبه لقواعد الإملاء: come -> coming (نحذف e)، run -> running (نضاعف الحرف الأخير)."
            ),
            keyPointsEn = listOf(
                "Happening right now: 'Look! It's raining.'",
                "Temporary situations around now: 'I'm reading a great book this week.'",
                "Spelling: drop final -e (make -> making); double CVC consonants (sit -> sitting)."
            ),
            examples = listOf(
                GrammarExample("Sarah is in her car. She's driving to work.", "الحدث مستمر لحظة الحديث.", "Action in progress right now."),
                GrammarExample("Where are the children? They're playing in the park.", "سؤال وجواب عن فعل حالي.", "Asking about current activity.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Positive", "الإثبات", "am/is/are + V-ing", "He is waiting."),
                GrammarComparisonRow("Negative", "النفي", "am/is/are + not + V-ing", "We aren't watching TV."),
                GrammarComparisonRow("Question", "السؤال", "Am/Is/Are + S + V-ing?", "Is it raining?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I'm knowing the answer.",
                    "I know the answer.",
                    "أفعال الإدراك والشعور (know, like, want, need) لا تأتي غالباً في المستمر.",
                    "State verbs (know, like, want, remember) are normally not used in continuous tenses."
                )
            ),
            murphyTipAr = "أفعال الحالة (Stative Verbs) مثل like, love, hate, want, need, know, understand تبقى في المضارع البسيط حتى لو كنت تقصد الآن.",
            murphyTipEn = "Verbs of thinking and feeling (know, want, like, believe) stay in the simple form even when talking about right now."
        ),
        GrammarUnitSummary(
            id = "u5_7",
            partId = "present",
            unitBadge = "Units 5–7",
            titleEn = "Present Simple (I do)",
            titleAr = "المضارع البسيط (للعادات والحقائق)",
            tldrAr = "يُعبّر عن الحقائق العامة والأشياء التي تتكرر بانتظام أو الأمور الدائمة.",
            tldrEn = "Expresses general truths, habits, repeated actions, and permanent situations.",
            formulaEn = "I/you/we/they + V1 | he/she/it + V1(-s/-es)",
            keyPointsAr = listOf(
                "نضيف -s أو -es للفعل مع he / she / it فقط (works, watches, studies).",
                "في النفي والسؤال نستخدم do / does ثم يعود الفعل للمصدر المجرد بدون s.",
                "ظروف التكرار (always, usually, often, sometimes, never) تأتي قبل الفعل الرئيسي وبعد be."
            ),
            keyPointsEn = listOf(
                "Add -s/-es only for he/she/it (goes, teaches, flies).",
                "Use do/don't and does/doesn't + base verb for questions and negatives.",
                "Adverbs of frequency (always, often, never) go before main verbs, after 'be'."
            ),
            examples = listOf(
                GrammarExample("The earth goes round the sun.", "حقيقة علمية ثابتة.", "Permanent general truth."),
                GrammarExample("What does this word mean?", "السؤال في المضارع البسيط باستخدام does.", "Present simple question with 'does'."),
                GrammarExample("She always arrives early.", "ظرف التكرار قبل الفعل الرئيسي.", "Frequency adverb before main verb.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Positive", "الإثبات", "S + V1 (+ s/es)", "He drinks coffee."),
                GrammarComparisonRow("Negative", "النفي", "S + don't/doesn't + V1", "He doesn't drink tea."),
                GrammarComparisonRow("Question", "السؤال", "Do/Does + S + V1?", "Does he work here?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Does she works in a bank?",
                    "Does she work in a bank?",
                    "بعد does أو doesn't نحذف حرف s من الفعل الرئيسي دائماً.",
                    "After 'does' or 'doesn't', use the base verb without -s."
                )
            ),
            murphyTipAr = "انتبه! الفعل have يتحول إلى has مع he/she/it، لكنه يعود إلى have بعد does: Does she have a car?",
            murphyTipEn = "Remember: 'have' becomes 'has' with he/she/it, but reverts to 'have' after does/doesn't."
        ),
        GrammarUnitSummary(
            id = "u8_9",
            partId = "present",
            unitBadge = "Units 8–9",
            titleEn = "Present Continuous vs Simple & Have Got",
            titleAr = "المقارنة بين المستمر والبسيط و Have got",
            tldrAr = "المستمر لما يحدث الآن أو بشكل مؤقت، والبسيط لما هو دائم أو متكرر، و have got للملكية.",
            tldrEn = "Continuous = now/temporary; Simple = general/permanent. 'have got' equals 'have' for possession.",
            formulaEn = "I am doing (now) vs I do (always) | I've got = I have",
            keyPointsAr = listOf(
                "Jim is watching TV now (الآن) مقابل Jim watches TV every evening (عادة يومية).",
                "للملكية والمرض والصفات في المضارع: I've got a headache = I have a headache.",
                "في النفي: I haven't got أو I don't have (كلاهما صحيح، والأخيرة أكثر شيوعاً في الماضي)."
            ),
            keyPointsEn = listOf(
                "Compare: 'It's raining' (right now) vs 'It rains a lot in winter' (in general).",
                "'I've got' = 'I have' for possession, family, and illnesses.",
                "Negative: 'I haven't got a key' = 'I don't have a key'."
            ),
            examples = listOf(
                GrammarExample("I'm living with friends until I find a flat.", "وضع مؤقت (مضارع مستمر).", "Temporary living situation."),
                GrammarExample("My parents live in London.", "وضع دائم (مضارع بسيط).", "Permanent home."),
                GrammarExample("Have you got a moment? — Yes, I have.", "استخدام have got في السؤال والرد.", "Using 'have got' in a question.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Now / Temp", "الآن / مؤقت", "am/is/are + V-ing", "We are eating lunch."),
                GrammarComparisonRow("Habit / Fact", "عادة / حقيقة", "V1 / V1-s", "We eat lunch at 1pm."),
                GrammarComparisonRow("Possession", "الملكية", "have/has got", "She's got two brothers.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I've got a shower every morning.",
                    "I have a shower every morning.",
                    "مع الأنشطة والأكل والاستحمام (have breakfast/a shower) نستخدم have فقط وليس have got.",
                    "For actions like 'have breakfast' or 'have a shower', never use 'have got'."
                )
            ),
            murphyTipAr = "لا تستخدم have got في الماضي! في الماضي نستخدم had / didn't have دائماً.",
            murphyTipEn = "Never use 'got' in the past! Always say 'I had' or 'I didn't have'."
        ),

        // PART 2: PAST TENSES
        GrammarUnitSummary(
            id = "u10_12",
            partId = "past",
            unitBadge = "Units 10–12",
            titleEn = "was/were & Past Simple (I did)",
            titleAr = "الماضي البسيط و was/were",
            tldrAr = "يُستخدم للأحداث المنتهية في وقت محدد بالماضي (yesterday, last week, in 2018).",
            tldrEn = "Used for completed actions or states at a finished time in the past.",
            formulaEn = "was/were | Subject + V2 (didn't + V1 / Did + S + V1?)",
            keyPointsAr = listOf(
                "was مع I/he/she/it، و were مع we/you/they.",
                "الأفعال المنتظمة تأخذ -ed (worked, stopped, studied)، والشاذة تُحفظ (went, saw, bought).",
                "في النفي والسؤال بالماضي البسيط نستخدم did/didn't ويعود الفعل للمصدر المجرد!"
            ),
            keyPointsEn = listOf(
                "Use 'was' for singular and 'were' for plural/you.",
                "Regular verbs add -ed; irregular verbs change form (go->went, see->saw).",
                "Questions & negatives use 'did/didn't' + base verb (Did you see? I didn't go)."
            ),
            examples = listOf(
                GrammarExample("Last year Rachel was 22, so she is 23 now.", "حالة في الماضي.", "Past state with 'was'."),
                GrammarExample("We enjoyed the party last night.", "فعل منتظم منتهٍ في الماضي.", "Regular past action."),
                GrammarExample("Did you watch the match? — No, I didn't.", "سؤال وجواب في الماضي البسيط.", "Past simple question and short answer.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Be (Past)", "فعل الكينونة", "was / were / wasn't", "They weren't at home."),
                GrammarComparisonRow("Positive", "الإثبات", "S + V2 (-ed / irregular)", "I saw Tom yesterday."),
                GrammarComparisonRow("Neg / Ques", "النفي والسؤال", "didn't + V1 / Did + S + V1?", "Did you call him?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Did you went to the cinema?",
                    "Did you go to the cinema?",
                    "بعد Did أو didn't نستخدم التصريف الأول المجرد (go) وليس الماضي (went).",
                    "Always use the base verb after 'did' or 'didn't', never V2."
                )
            ),
            murphyTipAr = "مع was/were لا نستخدم did أبداً! نقول: Was the weather good? و I wasn't tired.",
            murphyTipEn = "Never combine 'did' with 'was/were'. Ask 'Were you busy?' not 'Did you be busy?'."
        ),
        GrammarUnitSummary(
            id = "u13_14",
            partId = "past",
            unitBadge = "Units 13–14",
            titleEn = "Past Continuous vs Past Simple",
            titleAr = "الماضي المستمر مقابل الماضي البسيط",
            tldrAr = "الماضي المستمر يصف حدثاً كان قيد التنفيذ في لحظة بالماضي، وغالباً يقطعه حدث قصير بالماضي البسيط.",
            tldrEn = "Past Continuous describes an ongoing background action; Past Simple describes the shorter completed event that happened during it.",
            formulaEn = "was/were + V-ing (in progress) | when + Past Simple",
            keyPointsAr = listOf(
                "I was walking home when I met Dave (كنت أمشي عندما قابلت ديف).",
                "الأول (was walking) حدث طويل مستمر في الخلفية، والثاني (met) حدث قصير قاطع.",
                "لحدثين متتاليين (أحدهما بعد الآخر) نستخدم الماضي البسيط لكليهما."
            ),
            keyPointsEn = listOf(
                "Background action in progress: 'What were you doing at 10:30?'",
                "Interrupted action: 'I was cooking when the phone rang.'",
                "Sequential actions (one after another) both take Past Simple."
            ),
            examples = listOf(
                GrammarExample("It was raining when we went out.", "المطر كان مستمراً لحظة خروجنا.", "Rain in progress when we exited."),
                GrammarExample("When Karen arrived, we were having dinner.", "بدأنا العشاء قبل وصولها واستمررنا أثناءه.", "Dinner started before her arrival.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Continuous", "حدث مستمر", "was/were + V-ing", "She was reading at 8pm."),
                GrammarComparisonRow("Simple", "حدث قاطع/منتهٍ", "V2", "The lights went out.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "When I saw her, she wore a blue dress.",
                    "When I saw her, she was wearing a blue dress.",
                    "لوصف ما كان يرتديه أو يفعله شخص لحظة رؤيته نستخدم الماضي المستمر.",
                    "Use Past Continuous to describe what someone was wearing or doing at a specific moment."
                )
            ),
            murphyTipAr = "تذكر الفرق: When Karen arrived, we had dinner (وصلت أولاً ثم تعشينا) vs we were having dinner (كنا نتعشى بالفعل).",
            murphyTipEn = "Compare: 'When she arrived, we had dinner' (after) vs 'we were having dinner' (already in progress)."
        ),

        // PART 3: PRESENT PERFECT
        GrammarUnitSummary(
            id = "u15_17",
            partId = "present_perfect",
            unitBadge = "Units 15–17",
            titleEn = "Present Perfect (have/has + V3)",
            titleAr = "المضارع التام (have/has + التصريف الثالث)",
            tldrAr = "يربط الماضي بالحاضر: حدث وقع في الماضي ولكن أثره أو نتيجته ما زالت قائمة الآن، أو تجربة حياتية بدون تحديد وقت.",
            tldrEn = "Connects the past to the present: a past action with a result now, or life experience without a specific past time.",
            formulaEn = "Subject + have / has + Past Participle (V3)",
            keyPointsAr = listOf(
                "just = منذ لحظات قليلة: I've just had lunch.",
                "already = حدث أبكر من المتوقع: Don't forget to post it. — I've already posted it.",
                "yet = حتى الآن (في النفي والسؤال فقط وتأتي في آخر الجملة): Has it stopped raining yet?",
                "ever (في السؤال عن الخبرة) و never (للنفي): Have you ever been to Rome?"
            ),
            keyPointsEn = listOf(
                "'just' = a short time ago; 'already' = sooner than expected.",
                "'yet' = until now (used at the end of negatives and questions).",
                "'ever' = in your life so far (questions); 'never' = not at any time."
            ),
            examples = listOf(
                GrammarExample("I've lost my passport. (= I can't find it now)", "النتيجة حاضرة الآن.", "Past action with present result."),
                GrammarExample("They've gone to Italy vs They've been to Italy.", "gone = ذهب وما زال هناك | been = ذهب وعاد.", "gone = still there; been = went and returned.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Positive", "الإثبات", "have/has + V3", "She has finished."),
                GrammarComparisonRow("Negative", "النفي", "haven't/hasn't + V3", "I haven't seen it yet."),
                GrammarComparisonRow("Question", "السؤال", "Have/Has + S + V3?", "Have you ever tried sushi?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Where is Tom? He has been to the bank.",
                    "Where is Tom? He has gone to the bank.",
                    "إذا كان الشخص غير موجود حالياً لأنه ذهب إلى مكان، نستخدم gone وليس been.",
                    "Use 'has gone to' when the person is still at that place."
                )
            ),
            murphyTipAr = "الفرق بين gone و been من أشهر أسئلة مورفي: been تعني زار المكان وعاد، أما gone فتعني أنه هناك الآن!",
            murphyTipEn = "Classic Murphy distinction: 'gone to' = still there; 'been to' = visited and returned."
        ),
        GrammarUnitSummary(
            id = "u18_20",
            partId = "present_perfect",
            unitBadge = "Units 18–20",
            titleEn = "For, Since, Ago & vs Past Simple",
            titleAr = "الفرق بين For و Since و Ago والمقارنة بالماضي البسيط",
            tldrAr = "for للمدة الزمنية الكاملة، since لنقطة البداية، ago للماضي البسيط فقط. ولا نستخدم المضارع التام مع أوقات منتهية مثل yesterday!",
            tldrEn = "Use 'for' with a duration, 'since' with a starting point, and Past Simple whenever a finished time (yesterday, last year) is stated.",
            formulaEn = "for + period | since + start point | ago -> Past Simple",
            keyPointsAr = listOf(
                "for + مدة: for two hours, for six months, for a long time.",
                "since + نقطة بداية: since 8 o'clock, since Monday, since 2015.",
                "للسؤال عن المدة المستمرة حتى الآن نستخدم How long have you...؟ وليس How long are you...؟",
                "مع yesterday, last week, in 2010, at 3 o'clock نستخدم الماضي البسيط دائماً وليس المضارع التام."
            ),
            keyPointsEn = listOf(
                "'for' + length of time (for 3 days); 'since' + start of period (since Tuesday).",
                "Ask 'How long have you lived here?' (NOT 'How long are you living here?').",
                "Use Past Simple—not Present Perfect—with finished time words (yesterday, 2 hours ago)."
            ),
            examples = listOf(
                GrammarExample("Dan and Kate have been married for 20 years.", "حدث مستمر منذ 20 سنة وحتى الآن.", "Ongoing state for 20 years."),
                GrammarExample("I arrived in London two days ago.", "وجود ago يُلزم استخدام الماضي البسيط.", "'ago' requires Past Simple.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("for", "لمدة", "for + duration", "for three weeks"),
                GrammarComparisonRow("since", "منذ", "since + point in time", "since April / since I left"),
                GrammarComparisonRow("ago", "قبل (ماضي)", "period + ago + V2", "I met him ten minutes ago.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I have seen Lisa yesterday.",
                    "I saw Lisa yesterday.",
                    "yesterday وقت منتهٍ تماماً، لذلك يجب استخدام الماضي البسيط (saw).",
                    "Never use Present Perfect with finished times like 'yesterday' or 'last week'."
                ),
                CommonMistake(
                    "I'm studying English since three years.",
                    "I've been studying English for three years.",
                    "المضارع التام (أو التام المستمر) يُستخدم لما بدأ في الماضي وما زال مستمراً، ومعه for للمدة.",
                    "Use Present Perfect for actions continuing from past to present, and 'for' for durations."
                )
            ),
            murphyTipAr = "إذا ذكرت متى حدث الفعل بالضبط في الماضي (yesterday, in 1999, an hour ago)، أغلق باب المضارع التام واستخدم الماضي البسيط فوراً!",
            murphyTipEn = "If you say WHEN something happened in the past (yesterday, in 2015, an hour ago), you MUST use Past Simple."
        ),

        // PART 4: PASSIVE
        GrammarUnitSummary(
            id = "u21_22",
            partId = "passive",
            unitBadge = "Units 21–22",
            titleEn = "The Passive (is done / was done)",
            titleAr = "المبني للمجهول (في الأزمنة المختلفة)",
            tldrAr = "نستخدم المبني للمجهول عندما يكون التركيز على الحدث أو المفعول به وليس على من قام بالفعل.",
            tldrEn = "Used when the focus is on the action or the object rather than who performed it.",
            formulaEn = "be (am/is/are/was/were/has been) + Past Participle (V3)",
            keyPointsAr = listOf(
                "المضارع البسيط المجهول: Butter is made from milk.",
                "الماضي البسيط المجهول: This house was built 100 years ago.",
                "المستمر المجهول: The bridge is being repaired now.",
                "المضارع التام المجهول: My keys have been stolen! (ومع الفاعل نستخدم by: painted by Picasso)."
            ),
            keyPointsEn = listOf(
                "Present Simple Passive: am/is/are + V3.",
                "Past Simple Passive: was/were + V3.",
                "Continuous Passive: is/are being + V3; Perfect Passive: have/has been + V3.",
                "Use 'by' to mention who did the action."
            ),
            examples = listOf(
                GrammarExample("How often are these rooms cleaned?", "سؤال في المضارع المجهول.", "Present passive question."),
                GrammarExample("I was born in Cairo in 1998.", "معلومة الميلاد تأتي دائماً مبنية للمجهول في الماضي (was born).", "'be born' is always passive.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Present", "مضارع", "is / are + V3", "Office is cleaned daily."),
                GrammarComparisonRow("Past", "ماضي", "was / were + V3", "It was built in 1990."),
                GrammarComparisonRow("Continuous", "مستمر", "is/are being + V3", "The car is being fixed."),
                GrammarComparisonRow("Perfect", "تام", "has/have been + V3", "The room has been painted.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I am born in 1995.",
                    "I was born in 1995.",
                    "الولادة حدثت في الماضي، لذا نقول دائماً was born وليس am born.",
                    "Always say 'I was born' (past), never 'I am born'."
                )
            ),
            murphyTipAr = "أي جملة مبنية للمجهول لا بد أن تحتوي على شكل من أفعال (be) متبوعاً بالتصريف الثالث (V3)!",
            murphyTipEn = "Every passive verb form has two mandatory parts: a form of 'be' + a Past Participle (V3)."
        ),

        // PART 5: VERB FORMS
        GrammarUnitSummary(
            id = "u23_24",
            partId = "verb_forms",
            unitBadge = "Units 23–24",
            titleEn = "be/have/do & Regular/Irregular Verbs",
            titleAr = "استخدامات be/have/do والأفعال الشاذة",
            tldrAr = "فهم متى نستخدم be (+ V-ing أو V3) ومتى نستخدم do (+ المصدر) ومتى نستخدم have (+ V3) يمنع 90% من أخطاء الأزمنة.",
            tldrEn = "Knowing which auxiliary pairs with which verb form (be + -ing/V3, have + V3, do + base) prevents tense mix-ups.",
            formulaEn = "be + V-ing / V3 | have + V3 | do/did + V1",
            keyPointsAr = listOf(
                "be (am/is/are/was/were) يتبعها إما V-ing (مستمر) أو V3 (مجهول).",
                "have/has يتبعها دائماً التصريف الثالث V3 (مضارع تام).",
                "do/does/did يتبعها دائماً الفعل في المصدر المجرد V1.",
                "الأفعال الشاذة مثل cut/put/read تبقى كما هي في التصريفات الثلاثة (مع اختلاف نطق read)."
            ),
            keyPointsEn = listOf(
                "'be' combines with V-ing (continuous) or V3 (passive).",
                "'have/has' combines with V3 (perfect tenses).",
                "'do/does/did' combines with V1 (simple questions and negatives).",
                "Some irregular verbs don't change spelling (cost-cost-cost, put-put-put)."
            ),
            examples = listOf(
                GrammarExample("The letter hasn't arrived yet. (have + V3)", "have مع التصريف الثالث.", "have + past participle."),
                GrammarExample("The letter wasn't delivered yesterday. (be + V3)", "was مع التصريف الثالث للمجهول.", "be + past participle for passive.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("be + V-ing", "استمرار", "am/is/was + V-ing", "She is working."),
                GrammarComparisonRow("be + V3", "مجهول", "is/was + V3", "It was broken."),
                GrammarComparisonRow("have + V3", "تام", "have/has + V3", "I've broken it."),
                GrammarComparisonRow("do + V1", "بسيط", "do/does/did + V1", "Did it break?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I didn't knew about it.",
                    "I didn't know about it.",
                    "بعد did/didn't لا يأتي التصريف الثاني أبداً، بل المصدر المجرد.",
                    "Use base verb 'know' after 'didn't'."
                )
            ),
            murphyTipAr = "احفظ مجموعات الأفعال الشاذة المتشابهة معاً مثل: speak-spoke-spoken و break-broke-broken و write-wrote-written.",
            murphyTipEn = "Group irregular verbs by sound pattern (sing-sang-sung, drink-drank-drunk) to memorize them faster."
        ),

        // PART 6: FUTURE
        GrammarUnitSummary(
            id = "u25_26",
            partId = "future",
            unitBadge = "Units 25–26",
            titleEn = "Present Continuous & Going To (Future)",
            titleAr = "المستقبل للخطط والترتيبات (V-ing و going to)",
            tldrAr = "نستخدم المضارع المستمر للترتيبات المؤكدة (حجزت/اتفقنا)، و going to للنية المسبقة أو التوقع المبني على دليل واضح.",
            tldrEn = "Present Continuous = fixed arrangements with people/times. 'going to' = prior intentions or predictions with present evidence.",
            formulaEn = "am/is/are + V-ing (arranged) | am/is/are + going to + V1 (planned)",
            keyPointsAr = listOf(
                "I'm playing tennis with Julie tomorrow (اتفقنا وحجزنا الملعب — ترتيب مؤكّد).",
                "I'm going to buy some new shoes (لديّ نية وقرار مسبق، لكن لم أرتب مع أحد).",
                "Look at those black clouds! It's going to rain (توقع بدليل حالي واضح)."
            ),
            keyPointsEn = listOf(
                "Fixed arrangement (often with time/place): 'We're meeting at 7pm.'",
                "Personal intention/decision already made: 'I'm going to watch the film tonight.'",
                "Prediction based on visible evidence now: 'Watch out! That box is going to fall!'"
            ),
            examples = listOf(
                GrammarExample("What are you doing on Saturday evening?", "السؤال عن خطط وترتيبات الغد/السبت.", "Asking about weekend arrangements."),
                GrammarExample("She's going to study medicine.", "قرار ونية مستقبلية.", "Future intention.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Arrangement", "ترتيب مؤكد", "am/is/are + V-ing", "I'm flying to Paris Friday."),
                GrammarComparisonRow("Intention", "نية / قرار", "am/is/are + going to + V1", "I'm going to clean my room."),
                GrammarComparisonRow("Evidence", "توقع بدليل", "is going to + V1", "It's going to rain soon.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I will meet Alex at 5pm. (already arranged)",
                    "I'm meeting Alex at 5pm.",
                    "للترتيبات والمواعيد المقررة مسبقاً نستخدم المضارع المستمر أو going to وليس will.",
                    "Do not use 'will' for pre-arranged plans and appointments."
                )
            ),
            murphyTipAr = "مع الجداول الرسمية (قطارات، طائرات، أفلام) نستخدم المضارع البسيط: The train leaves at 7:30.",
            murphyTipEn = "For public timetables (trains, flights, cinema), English uses Present Simple: 'The concert starts at 8.'"
        ),
        GrammarUnitSummary(
            id = "u27_28",
            partId = "future",
            unitBadge = "Units 27–28",
            titleEn = "will / shall (Spontaneous Future)",
            titleAr = "استخدام will و shall للمستقبل",
            tldrAr = "نستخدم will للقرارات اللحظية التي تتخذها أثناء الكلام، والوعود، والعروض، والتوقعات العامة بدون خطة مسبقة.",
            tldrEn = "Use 'will' for instant decisions made at the moment of speaking, offers, promises, and general predictions.",
            formulaEn = "Subject + will ('ll) / will not (won't) + V1",
            keyPointsAr = listOf(
                "قرار لحظي الآن: Oh, I left the door open. I'll go and shut it.",
                "عرض مساعدة أو وعد: That bag looks heavy. I'll help you. / I won't tell anyone.",
                "غالباً تأتي مع I think / I don't think / probably: I think Kelly will pass the exam.",
                "Shall I...? / Shall we...? تُستخدم فقط لتقديم عرض أو اقتراح بصيغة سؤال."
            ),
            keyPointsEn = listOf(
                "Instant decision right now: 'I'll have a coffee, please.'",
                "Offers & promises: 'I'll carry that for you.' / 'I won't be late.'",
                "Common with 'I think', 'I hope', 'probably': 'I think it will rain tomorrow.'",
                "Use 'Shall I...?' or 'Shall we...?' to offer help or suggest an activity."
            ),
            examples = listOf(
                GrammarExample("I'm too tired to walk home. I think I'll get a taxi.", "قرار فوري اتُخذ لحظة الكلام.", "Decision made at the moment of speaking."),
                GrammarExample("Shall I open the window? — Yes, please.", "عرض مساعدة بأسلوب مهذب.", "Polite offer with Shall I.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Positive", "الإثبات", "S + 'll / will + V1", "I'll phone you tonight."),
                GrammarComparisonRow("Negative", "النفي", "S + won't + V1", "She won't come."),
                GrammarComparisonRow("Offer", "اقتراح / عرض", "Shall I / Shall we + V1?", "Shall we go out?")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I think it rains tomorrow.",
                    "I think it will rain tomorrow.",
                    "للتوقع المستقبلي مع I think نستخدم will + المصدر.",
                    "Use 'will' for future predictions with 'I think'."
                )
            ),
            murphyTipAr = "تذكّر قاعدة مورفي: النفي من I think هو غالباً I don't think... will وليس I think... won't!",
            murphyTipEn = "Natural English prefers 'I don't think it will rain' rather than 'I think it won't rain'."
        ),

        // PART 7: MODALS & IMPERATIVES
        GrammarUnitSummary(
            id = "u29_31",
            partId = "modals",
            unitBadge = "Units 29–31",
            titleEn = "might, can, could & must",
            titleAr = "الاحتمال والاستطاعة والإلزام (might / can / could / must)",
            tldrAr = "الأفعال الناقصة لا تأخذ s مع المفرد، ولا يأتي بعدها to، ويتبعها الفعل في المصدر المجرد دائماً.",
            tldrEn = "Modal verbs never take -s, never use 'do/does', and are always followed by the bare infinitive (V1).",
            formulaEn = "Subject + might / can / could / must + V1",
            keyPointsAr = listOf(
                "might = ربما (احتمال غير مؤكد في الحاضر أو المستقبل): I might go to the cinema.",
                "can = يستطيع / مسموح (حاضر) | could = استطاع (ماضي) أو طلب مهذب (Could you...?).",
                "must = يجب بقوة (التزام داخلي أو قانون): You must see this film!",
                "mustn't = ممنوع بتاتاً | needn't = ليس ضرورياً (لا داعي)."
            ),
            keyPointsEn = listOf(
                "'might' = possibility (50/50 chance): 'Take an umbrella. It might rain.'",
                "'can' = ability/permission now; 'could' = past ability or polite requests.",
                "'must' = strong obligation; 'mustn't' = forbidden; 'needn't' = not necessary."
            ),
            examples = listOf(
                GrammarExample("Could you open the door, please?", "طلب مهذب باستخدام Could.", "Polite request."),
                GrammarExample("You mustn't touch that! It's dangerous.", "منع وتحذير (ممنوع).", "Prohibition with mustn't."),
                GrammarExample("You needn't hurry. We have plenty of time.", "انتفاء الحاجة (لا داعي).", "No necessity with needn't.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("might", "احتمال", "might (not) + V1", "She might be at home."),
                GrammarComparisonRow("can / could", "استطاعة/طلب", "can / could + V1", "Can you swim?"),
                GrammarComparisonRow("mustn't", "ممنوع", "mustn't + V1", "You mustn't smoke here."),
                GrammarComparisonRow("needn't", "لا داعي", "needn't + V1", "You needn't pay now.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "He cans speak three languages.",
                    "He can speak three languages.",
                    "الأفعال الناقصة لا يضاف لها s مع he/she/it.",
                    "Never add -s to modal verbs."
                )
            ),
            murphyTipAr = "انتبه للفرق الكبير في المعنى: You mustn't go (ممنوع أن تذهب) ≠ You needn't go (لست مضطراً للذهاب، لك الحرية).",
            murphyTipEn = "Crucial difference: 'mustn't' = DON'T do it; 'needn't' = it's not necessary (your choice)."
        ),
        GrammarUnitSummary(
            id = "u32_36",
            partId = "modals",
            unitBadge = "Units 32–36",
            titleEn = "should, have to, would like & used to",
            titleAr = "النصيحة والالتزام والعادات القديمة (should / have to / used to)",
            tldrAr = "should للنصيحة، have to للضرورة المفروضة (ومضارعها وماضيها)، would like للطلب المهذب، و used to لعادات الماضي التي توقفت.",
            tldrEn = "'should' gives advice; 'have to' expresses external obligation; 'used to' describes past habits that are no longer true.",
            formulaEn = "should + V1 | have to + V1 | used to + V1",
            keyPointsAr = listOf(
                "should / shouldn't = من الجيد أن / أنصحك بـ: You should sleep earlier.",
                "have to / has to = مضطر إلى (بسبب قانون أو ظرف): I have to wear glasses. الماضي: had to.",
                "don't have to = لست مضطراً (لا داعي). السؤال: Do you have to...?",
                "used to + V1 = اعتاد على فعل شيء في الماضي ولم يعد يفعله الآن: I used to play tennis."
            ),
            keyPointsEn = listOf(
                "'should' = advice or opinion ('You look tired, you should go to bed').",
                "'have to' = rule or external necessity (past: 'had to', negative: 'don't have to').",
                "'Would you like...?' = polite offer (≠ 'Do you like...?' which asks about general taste).",
                "'used to + V1' = past habit/state that no longer exists (negative: 'didn't use to')."
            ),
            examples = listOf(
                GrammarExample("I had to walk home last night. There were no buses.", "الالتزام في الماضي يكون دائماً بـ had to.", "Past obligation uses 'had to'."),
                GrammarExample("Would you like a cup of coffee? — Yes, please.", "عرض مهذب.", "Polite offer."),
                GrammarExample("Dave used to work in a factory. Now he works in a shop.", "عادة أو وضع قديم انتهى.", "Past situation that changed.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("should", "نصيحة", "should(n't) + V1", "You shouldn't work so hard."),
                GrammarComparisonRow("have to", "إلزام خارجي", "have/has/had to + V1", "Did you have to wait?"),
                GrammarComparisonRow("used to", "عادة ماضية", "used to / didn't use to + V1", "I used to live in Madrid.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I am used to live in a small town.",
                    "I used to live in a small town.",
                    "للعادات القديمة نقول used to + V1 مباشرة بدون am/is/are.",
                    "For past habits, say 'I used to live' without 'am'."
                )
            ),
            murphyTipAr = "لا يوجد ماضٍ من must! في الماضي نستخدم دائماً had to، وفي المستقبل will have to.",
            murphyTipEn = "'must' has no past form — always use 'had to' for the past."
        ),

        // PART 8: THERE & IT
        GrammarUnitSummary(
            id = "u37_39",
            partId = "there_it",
            unitBadge = "Units 37–39",
            titleEn = "there is/are & It...",
            titleAr = "التعبير عن الوجود (there is/are) والضمير It",
            tldrAr = "نستخدم there is/are للحديث عن وجود شيء لأول مرة، بينما نستخدم It للوقت والمسافة والطقس ووصف الأشياء.",
            tldrEn = "Use 'there is/are' to say something exists; use 'it' for time, days, distance, weather, and referring back to things.",
            formulaEn = "there is/was/will be (singular) | there are/were (plural) | It is...",
            keyPointsAr = listOf(
                "there is للمفرد وغير المعدود، و there are للجمع: There's a big tree. / There are some books.",
                "في الماضي: there was / there were. وفي المضارع التام: there has been / have been.",
                "نستخدم It مع الوقت والطقس والمسافة: It's 10 o'clock. / It's raining. / It's 3 miles to the station.",
                "It's nice to see you / It's easy to understand."
            ),
            keyPointsEn = listOf(
                "Use 'there is' + singular/uncountable and 'there are' + plural.",
                "Past: 'there was/were'; Future: 'there will be'; Perfect: 'there has/have been'.",
                "Use 'It' for time, dates, weather, distance, and 'It is + adj + to...'."
            ),
            examples = listOf(
                GrammarExample("There's a train at 10:30. It's a fast train.", "there قدّمت المعلومة، ثم it أشارت إليها.", "'there' introduces it; 'it' refers back to it."),
                GrammarExample("How far is it from here to the airport?", "للمسافة نستخدم It دائماً.", "Distance always uses 'it'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Existence", "الوجود", "There is / are / was / will be", "There were many people."),
                GrammarComparisonRow("Weather/Time", "الطقس/الوقت", "It is / was + adj/time", "It was sunny yesterday."),
                GrammarComparisonRow("Adj + to", "صفة + مصدر", "It's + adj + to + V1", "It's easy to learn.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "Have many cars in the street.",
                    "There are many cars in the street.",
                    "لا نقول Have لبيان وجود أشياء في مكان، بل There is / There are.",
                    "Never start an existence sentence with 'Have'; use 'There is/are'."
                )
            ),
            murphyTipAr = "تذكّر الفرق البسيط: There's a book on the table (يوجد كتاب)، أما It's an interesting book (إنه كتاب ممتع - وصف الشيء المحدد).",
            murphyTipEn = "Think of it like this: 'There is' = it exists; 'It is' = describing that specific thing."
        )
    )
}
