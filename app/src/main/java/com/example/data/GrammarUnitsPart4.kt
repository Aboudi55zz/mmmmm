package com.example.data

import com.example.model.CommonMistake
import com.example.model.GrammarComparisonRow
import com.example.model.GrammarExample
import com.example.model.GrammarUnitSummary

object GrammarUnitsPart4 {
    val units: List<GrammarUnitSummary> = listOf(
        // PART 19: PREPOSITIONS & PHRASAL VERBS (Units 103-115)
        GrammarUnitSummary(
            id = "u103_105",
            partId = "prepositions_phrasal",
            unitBadge = "Units 103–105",
            titleEn = "Time Prepositions (at/on/in, until, during/while)",
            titleAr = "حروف جر الزمان (at / on / in / until / during / while)",
            tldrAr = "at للساعات، on للأيام والتواريخ، in للشهور والسنوات؛ و during + اسم بينما while + جملة (فاعل وفعل).",
            tldrEn = "'at' for clock times, 'on' for days/dates, 'in' for months/years. Use 'during + noun' vs 'while + subject + verb'.",
            formulaEn = "at 8:00 | on Monday | in May | until (up to) | during + noun | while + S + V",
            keyPointsAr = listOf(
                "at 10:30 / at midnight / at night / at the weekend / at Christmas.",
                "on Friday / on 12 May / on Sunday morning / on my birthday.",
                "in April / in 2026 / in summer / in the morning (ولكن بدون حرف جر قبل this/last/next/every!).",
                "during + اسم (أثناء): I fell asleep during the film. | while + جملة: I fell asleep while I was watching TV.",
                "until = حتى (نهاية فترة مستمرة): Stay here until I come back. | by = قبل أو في موعد أقصاه."
            ),
            keyPointsEn = listOf(
                "Pyramid: AT (clock times, night), ON (days, dates), IN (months, seasons, years, parts of day).",
                "NO preposition before 'this / last / next / every' ('See you next Friday').",
                "'during' + noun ('during the concert'); 'while' + clause ('while we were eating').",
                "'for' + duration ('for two hours') vs 'during' + event ('during the night')."
            ),
            examples = listOf(
                GrammarExample("The course starts on 7 January and ends in March.", "on للتاريخ الكامل و in للشهر.", "'on' + date vs 'in' + month."),
                GrammarExample("We didn't speak during the meal. / Don't talk while you're eating.", "during تليها كلمة meal، و while تليها جملة.", "'during' + noun vs 'while' + clause.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("at / on / in", "الوقت", "at 5pm / on Monday / in 2026", "at night / on 4 July"),
                GrammarComparisonRow("during / while", "أثناء", "during + noun | while + S + V", "during work / while I worked"),
                GrammarComparisonRow("until / from..to", "من.. إلى", "from X to Y / until + end", "Wait until 6 o'clock.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I'll see you on next Tuesday. / I met him during I was in Paris.",
                    "I'll see you next Tuesday. / I met him while I was in Paris.",
                    "لا نضع on قبل next، وبعدها جملة كاملة نستخدم while وليس during.",
                    "Omit 'on' before 'next'; use 'while' before a subject+verb clause."
                )
            ),
            murphyTipAr = "احفظ التمييز الثلاثي من مورفي: for + رقم/مدة (for 2 hours)، during + اسم حدث (during the meeting)، while + فاعل وفعل (while I was waiting).",
            murphyTipEn = "Three-way split: 'for' + length of time, 'during' + noun event, 'while' + subject + verb."
        ),
        GrammarUnitSummary(
            id = "u106_110",
            partId = "prepositions_phrasal",
            unitBadge = "Units 106–110",
            titleEn = "Prepositions of Place & Movement (in/at/on, to, over)",
            titleAr = "حروف جر المكان والحركة (in / at / on / to / across)",
            tldrAr = "in داخل حيّز مغلق أو مدينة، on على سطح أو شارع، at عند نقطة أو مكان عام؛ أما to فتشير للحركة والاتجاه نحو وجهة.",
            tldrEn = "'in' = enclosed space/city; 'on' = surface/floor/line; 'at' = specific point/event. 'to' shows movement towards a destination.",
            formulaEn = "in (inside) | on (surface) | at (point) | go/fly/walk + to (movement)",
            keyPointsAr = listOf(
                "in: in a room, in a box, in London, in bed, in the sky, in a newspaper.",
                "on: on the table, on the wall, on the second floor, on the left/right, on a bus/train/plane.",
                "at: at the bus stop, at the door, at home, at work, at university, at the top/bottom.",
                "الحركة: go to Paris / drive to the airport (لكن: arrive IN a city / arrive AT a building / get TO a place / go home بدون to!).",
                "حروف اتجاه وحركة: into (إلى الداخل), out of (للخارج), across (عبر السطح), through (عبر نفق/غابة), past (بمحاذاة)."
            ),
            keyPointsEn = listOf(
                "'in' = inside a 3D space or town/country; 'on' = touching a surface or public transport (on the train); 'at' = pinpoint or event.",
                "Movement uses 'to': 'go to London', 'walk to work' (EXCEPT 'go home', no 'to').",
                "Arrival: 'arrive IN a country/city' vs 'arrive AT a station/hotel'.",
                "Position & motion: next to, between, opposite, in front of, behind, into, out of, over, under, through, across."
            ),
            examples = listOf(
                GrammarExample("When did you arrive in London? / What time did you get to the hotel?", "arrive in للمدن و get to للأماكن.", "'arrive in' vs 'get to'."),
                GrammarExample("The cat jumped over the wall and ran across the garden.", "حركة فوق (over) وعبر السطح (across).", "Movement prepositions.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("in / on / at", "الموقع", "in room / on wall / at door", "on the bus / at home"),
                GrammarComparisonRow("Arrival", "الوصول", "arrive in/at | get to", "arrived in Cairo / at the airport"),
                GrammarComparisonRow("Movement", "الحركة", "into / out of / through / across", "walk through the park")
            ),
            mistakes = listOf(
                CommonMistake(
                    "We arrived to London at 6pm. / We went at the beach.",
                    "We arrived in London at 6pm. / We went to the beach.",
                    "الفعل arrive لا يأخذ to أبداً (يأخذ in أو at)، والفعل go للحركة يأخذ to.",
                    "Never say 'arrive to'; say 'arrive in/at' (or 'get to'). Use 'go to' for movement."
                )
            ),
            murphyTipAr = "مع المواصلات: نقول by car / by bus / by train / on foot (بدون أداة)، لكن عند استخدام a/my نبدّل: in my car / on the bus!",
            murphyTipEn = "Transport rule: 'by car / by train' (no article), OR 'in a car / on the train / on a bike'."
        ),
        GrammarUnitSummary(
            id = "u111_113",
            partId = "prepositions_phrasal",
            unitBadge = "Units 111–113",
            titleEn = "Prepositions + Nouns, Adjectives & Verbs",
            titleAr = "حروف الجر الثابتة مع الأسماء والصفات والأفعال",
            tldrAr = "كثير من الصفات والأفعال الإنجليزية ترتبط بحرف جر ثابت يغيّر المعنى أو يكمله (interested in, good at, listen to, wait for).",
            tldrEn = "Common nouns, adjectives, and verbs take fixed prepositions (on holiday, afraid of, good at, listen to, depend on).",
            formulaEn = "on holiday / by mistake | adj + prep + V-ing | verb + prep + object",
            keyPointsAr = listOf(
                "مع الأسماء: on holiday, on business, on TV, on the phone, by mistake, by chance, in love, in a hurry.",
                "مع الصفات: afraid of, proud of, full of | good at, bad at | interested in | married to, similar to | angry with (شخص) / about (شيء).",
                "مع الأفعال: listen to, talk to, look at, wait for, ask for, look for (يبحث), look after (يعتني), depend on, believe in.",
                "أفعال لا تأخذ حرف جر في الإنجليزية (خلافاً للعربية!): phone someone, call someone, thank someone, answer a question."
            ),
            keyPointsEn = listOf(
                "Noun phrases: on holiday, on fire, on the radio, by mistake, by credit card (but 'in cash').",
                "Adjective + prep: afraid of, interested in, good/bad at, famous for, responsible for, different from.",
                "Verb + prep: listen to, look at, wait for, belong to, happen to, depend on, think about.",
                "NO preposition after: phone/call someone, ask someone, thank someone, answer a question."
            ),
            examples = listOf(
                GrammarExample("Are you interested in art? — Yes, I'm quite good at drawing.", "interested IN و good AT (+ V-ing).", "Fixed adjective prepositions."),
                GrammarExample("Who are you waiting for? — I'm looking for my keys.", "في السؤال يبقى حرف الجر في النهاية.", "Preposition at the end of questions.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Adj + Prep", "صفة + حرف جر", "afraid of / good at / keen on", "She is afraid of spiders."),
                GrammarComparisonRow("Verb + Prep", "فعل + حرف جر", "listen to / wait for / depend on", "It depends on the weather."),
                GrammarComparisonRow("No Prep", "بدون حرف جر", "phone / call / thank / answer", "Call me tomorrow.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I'm listening music. / She is married with a doctor.",
                    "I'm listening to music. / She is married to a doctor.",
                    "listen تأخذ دائماً to قبل المفعول، و married تأخذ to وليس with.",
                    "Always say 'listen TO something' and 'married TO someone'."
                )
            ),
            murphyTipAr = "تذكّر الفرق في Look: look at (ينظر إلى)، look for (يبحث عن)، look after (يعتني بـ)، look forward to + V-ing (يتطلع بشوق إلى)!",
            murphyTipEn = "'look' changes completely with its preposition: look at (see), look for (search), look after (take care of)."
        ),
        GrammarUnitSummary(
            id = "u114_115",
            partId = "prepositions_phrasal",
            unitBadge = "Units 114–115",
            titleEn = "Phrasal Verbs (put on, turn off, give up)",
            titleAr = "الأفعال المركبة (الفعل + حرف ظرفي)",
            tldrAr = "الفعل المركب يجمع فعلاً بسيطاً مع حرف مثل on/off/up/out/away ليعطي معنى جديداً، ومع الضمائر مثل it/them نفصل الفعل عن الحرف.",
            tldrEn = "Phrasal verbs pair a verb with a particle (in, out, on, off, up, down, away) creating a new meaning. Pronouns always go in the middle.",
            formulaEn = "put on your coat = put your coat on | ALWAYS: put it on",
            keyPointsAr = listOf(
                "أفعال لا تأخذ مفعولاً: get up (يستيقظ), wake up, sit down, stand up, go out, come back, break down (تتعطل السيارة), take off (تقلع الطائرة).",
                "أفعال تقبل المفعول والفصل: turn on/off (يشغّل/يطفئ), put on (يرتدي), take off (يخلع), pick up (يلتقط), put down, throw away, turn up/down (يرفع/يخفض الصوت).",
                "قاعدة الضمير الصارمة: إذا كان المفعول ضميراً (it, them, him, her) يجب وضعه بين الفعل والحرف: Turn it off! (وليس Turn off it!)."
            ),
            keyPointsEn = listOf(
                "Intransitive (no object): get up, wake up, come in, go away, break down, grow up.",
                "Separable (with object): 'Turn off the light' OR 'Turn the light off'.",
                "MANDATORY with pronouns (it/them): 'Turn it off' (NEVER 'Turn off it')."
            ),
            examples = listOf(
                GrammarExample("My car broke down on the motorway.", "break down = تتعطل السيارة أو الآلة.", "Intransitive phrasal verb."),
                GrammarExample("Here are your glasses. Put them on.", "الضمير them جاء بين Put و on.", "Pronoun between verb and particle.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Noun Object", "مع اسم", "V + P + N OR V + N + P", "Take off your shoes / Take your shoes off."),
                GrammarComparisonRow("Pronoun Obj", "مع ضمير", "V + it/them + P (ONLY)", "Take them off!"),
                GrammarComparisonRow("Common", "شائعة", "give up / look up / carry on", "Never give up!")
            ),
            mistakes = listOf(
                CommonMistake(
                    "The TV is too loud. Please turn down it.",
                    "The TV is too loud. Please turn it down.",
                    "الضمير it/them يأتي دائماً في المنتصف بين الفعل والحرف.",
                    "Always place 'it' or 'them' between the verb and the particle."
                )
            ),
            murphyTipAr = "حرف 'off' غالباً يعني الإزالة أو الإطفاء أو الانفصال (take off, turn off, switch off)، و 'up' غالباً يعني الإكمال أو الرفع (wash up, wake up, pick up).",
            murphyTipEn = "Particles have logic: 'off' often means disconnect/remove; 'on' means connect/continue; 'up' often means finish/increase."
        ),

        // PART 20: APPENDICES 1-7
        GrammarUnitSummary(
            id = "app_1_3",
            partId = "appendices",
            unitBadge = "Appendices 1–3",
            titleEn = "Active/Passive & Irregular Verbs Master Guide",
            titleAr = "ملحق المبني للمجهول وجدول الأفعال الشاذة",
            tldrAr = "ملخص أنماط الأفعال الشاذة في الإنجليزية مصنفة حسب التشابه الصوتي لتسهيل حفظ تصريفاتها الثلاثة دون عناء.",
            tldrEn = "Master irregular verbs grouped by sound & spelling patterns, plus the complete Active-to-Passive quick conversion chart.",
            formulaEn = "V1 (Base) -> V2 (Past Simple) -> V3 (Past Participle)",
            keyPointsAr = listOf(
                "النمط 1 (متطابقة تماماً): cost-cost-cost | cut-cut-cut | hit-hit-hit | hurt-hurt-hurt | let-let-let | put-put-put | shut-shut-shut.",
                "النمط 2 (V2 = V3): buy-bought-bought | bring-brought-brought | catch-caught-caught | teach-taught-taught | think-thought-thought.",
                "النمط 3 (i - a - u): begin-began-begun | drink-drank-drunk | ring-rang-rung | sing-sang-sung | swim-swam-swum.",
                "النمط 4 (-ew / -own): blow-blew-blown | fly-flew-flown | grow-grew-grown | know-knew-known | throw-threw-thrown.",
                "النمط 5 (تصريفات مختلفة بـ -en): break-broke-broken | choose-chose-chosen | speak-spoke-spoken | steal-stole-stolen | write-wrote-written."
            ),
            keyPointsEn = listOf(
                "Group 1 (All same): cost, cut, hit, hurt, let, put, read (/ri:d/ -> /red/ -> /red/), shut.",
                "Group 2 (V2 = V3): feel-felt-felt, keep-kept-kept, sleep-slept-slept, leave-left-left, send-sent-sent.",
                "Group 3 (-ought/-aught): buy-bought, bring-brought, catch-caught, teach-taught, think-thought.",
                "Group 4 (i -> a -> u): begin-began-begun, drink-drank-drunk, sing-sang-sung, swim-swam-swum.",
                "Group 5 (-en V3): break-broke-broken, speak-spoke-spoken, take-took-taken, give-gave-given, see-saw-seen."
            ),
            examples = listOf(
                GrammarExample("Active: They built this house. -> Passive: This house was built.", "تحويل الماضي البسيط من معلوم إلى مجهول.", "Past simple active to passive."),
                GrammarExample("I've written three emails (V3) / I wrote one yesterday (V2).", "V2 للماضي البسيط و V3 للمضارع التام والمجهول.", "Using V2 vs V3 accurately.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Same (1=2=3)", "متطابقة", "cut / put / let / cost", "It cost £10 / It has cost £10."),
                GrammarComparisonRow("Past = V3", "تشابه 2 و 3", "made / bought / found / told", "I found it / I've found it."),
                GrammarComparisonRow("All 3 Diff", "مختلفة", "go-went-gone / do-did-done", "She went / She has gone.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I have wrote the letter. / He has drank all the juice.",
                    "I have written the letter. / He has drunk all the juice.",
                    "بعد have / has نستخدم التصريف الثالث (written / drunk) وليس الثاني (wrote / drank).",
                    "Always use the 3rd form (V3: written, drunk, spoken) after have/has/be."
                )
            ),
            murphyTipAr = "انتبه للفعل read: يُكتب بنفس الحروف في التصريفات الثلاثة، لكن نطقه في الحاضر /riːd/ وفي الماضي والتصريف الثالث /red/ مثل اللون الأحمر!",
            murphyTipEn = "Watch out for 'read': same spelling in all three forms, but pronounced like 'red' in V2 and V3."
        ),
        GrammarUnitSummary(
            id = "app_4_5",
            partId = "appendices",
            unitBadge = "Appendices 4–5",
            titleEn = "Short Forms (Contractions) & Spelling Rules",
            titleAr = "ملحق الاختصارات وقواعد الإملاء (-s, -ing, -ed, -er)",
            tldrAr = "قواعد كتابة النهايات الإملائية بدقة عند إضافة -s أو -ing أو -ed أو -er/-est، ومعاني الاختصارات المتشابهة مثل 's و 'd.",
            tldrEn = "Master spelling changes when adding -s/-es, -ing, -ed, -er/-est, and -ly, plus how to read ambiguous contractions ('s and 'd).",
            formulaEn = "'s = is OR has | 'd = would OR had | CVC -> double final consonant",
            keyPointsAr = listOf(
                "الاختصار 's يعني is مع الصفة/V-ing (He's tall / He's working)، ويعني has مع V3/got (He's gone / He's got).",
                "الاختصار 'd يعني would مع المصدر (I'd like / I'd go)، ويعني had مع التصريف الثالث (I'd finished).",
                "حذف e الصامتة قبل -ing/-ed/-er: make -> making, live -> lived, late -> later (لكن ee تبقى: see -> seeing).",
                "تحويل y إلى i بعد حرف ساكن: study -> studies / studied, happy -> happier / happily (لكن بعد حرف علة تبقى: play -> played).",
                "مضاعفة الحرف الساكن الأخير في الكلمات القصيرة (CVC): stop -> stopping / stopped, big -> bigger (لا نضاعف w/x/y: snow -> snowing)."
            ),
            keyPointsEn = listOf(
                "'s = is (He's here / He's coming) OR has (He's arrived / He's got).",
                "'d = would (I'd love to / I'd buy it) OR had (I'd already eaten).",
                "Final -s/-es: add -es after -s/-sh/-ch/-x (watches, boxes) and consonant+y -> -ies (flies).",
                "Drop silent -e before -ing/-ed/-er (hope -> hoping); consonant + y -> ied/ier/ily (try -> tried).",
                "Double final consonant in stressed 1-syllable CVC words (plan -> planned, thin -> thinner; never double w/x/y)."
            ),
            examples = listOf(
                GrammarExample("She's going (is) vs She's gone (has) | I'd go (would) vs I'd gone (had)", "السياق والفعل التالي يحددان معنى الاختصار.", "Context tells you what 's and 'd mean."),
                GrammarExample("stop -> stopped / stopping | study -> studies / studied", "تطبيق قواعد المضاعفة وتحويل حرف y.", "Doubling CVC and consonant+y rules.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("C + y", "ساكن + y", "-ies / -ied / -ier / -ily", "try -> tries, easy -> easier"),
                GrammarComparisonRow("V + y", "علة + y", "-ys / -yed (no change)", "play -> plays -> played"),
                GrammarComparisonRow("Silent -e", "حرف e صامت", "drop -e before -ing/-ed", "write -> writing, nice -> nicer"),
                GrammarComparisonRow("1-Syl CVC", "مضاعفة", "double last consonant", "sit -> sitting, hot -> hotter")
            ),
            mistakes = listOf(
                CommonMistake(
                    "stoped / studyed / writting / happly",
                    "stopped / studied / writing / happily",
                    "تُضاعف p في stopped، وتُحول y إلى i في studied/happily، ولا تُضاعف t في writing.",
                    "Double p in 'stopped', change y->i in 'studied/happily', single t in 'writing'."
                )
            ),
            murphyTipAr = "حيلة ممتازة للفرق بين -ed و -ing: الفعل lie (يستلقي/يكذب) يصبح lying و die يصبح dying و tie يصبح tying (نقلب ie إلى y ثم نضيف ing)!",
            murphyTipEn = "Special -ie spelling rule: die -> dying, lie -> lying, tie -> tying."
        ),
        GrammarUnitSummary(
            id = "app_6_7",
            partId = "appendices",
            unitBadge = "Appendices 6–7",
            titleEn = "Essential Phrasal Verbs Quick Reference",
            titleAr = "ملحق مرجعي لأهم الأفعال المركبة في الكتاب",
            tldrAr = "قائمة مركّزة لأكثر الأفعال المركبة استخداماً في الحياة اليومية والامتحانات من ملحقي 6 و 7 في كتاب ريموند مورفي.",
            tldrEn = "High-frequency phrasal verbs from Murphy's Appendices 6 & 7, grouped by meaning and separability.",
            formulaEn = "Verb + Particle (Literal vs Idiomatic meaning)",
            keyPointsAr = listOf(
                "حركة وتنقل: get in/out (سيارة), get on/off (حافلة/قطار/طائرة), check in/out (فندق/مطار), drive off, come back.",
                "منزل وأجهزة: turn on / switch on (يشغّل), turn off (يطفئ), turn up/down (يرفع/يخفض الصوت), tidy up (يرتب), wash up (يغسل الصحون).",
                "أنشطة يومية: fill in / fill out (يملأ استمارة), look up (يبحث عن كلمة في قاموس), try on (يجرب ملابس), give back (يرجع شيئاً).",
                "معانٍ مجازية مهمة: find out (يكتشف), give up (يتوقف/يستسلم), carry on / go on (يستمر), look forward to (يتطلع بشوق لـ + V-ing)."
            ),
            keyPointsEn = listOf(
                "Transport: get in/out of a car; get on/off a bus, train, plane, or bike.",
                "Everyday actions: fill in a form, look up a word, try on clothes, put away things, throw away rubbish.",
                "Continuation & Stop: carry on / go on (= continue), give up (= stop trying/doing), break down (= stop working).",
                "High-frequency idiom: 'look forward to + -ing' ('I'm looking forward to seeing you')."
            ),
            examples = listOf(
                GrammarExample("Please fill in this form and give it back to the receptionist.", "fill in = يملأ استمارة، give back = يعيد.", "fill in & give back."),
                GrammarExample("I'm looking forward to meeting you next week.", "بعد look forward to يأتي V-ing وليس المصدر المجرد!", "'look forward to + -ing'.")
            ),
            structureTable = listOf(
                GrammarComparisonRow("Transport", "المواصلات", "get in/out (car) | on/off (bus)", "We got off the bus at the museum."),
                GrammarComparisonRow("Study/Work", "دراسة/عمل", "find out / look up / fill in", "Look it up in the dictionary."),
                GrammarComparisonRow("Attitude", "استمرار/توقف", "carry on / give up / put off", "Don't put it off until tomorrow.")
            ),
            mistakes = listOf(
                CommonMistake(
                    "I look forward to see you soon. / We got down from the bus.",
                    "I look forward to seeing you soon. / We got off the bus.",
                    "to في look forward to حرف جر يأخذ -ing، وللنزول من الحافلة نستخدم get off.",
                    "Use -ing after 'look forward to', and use 'get off' (not 'get down') for buses/trains."
                )
            ),
            murphyTipAr = "ملاحظة مورفي للمواصلات: للسيارة والتاكسي نستخدم get in / get out of (لأنك تنحني للدخول)، وللحافلة والقطار والطائرة نستخدم get on / get off!",
            murphyTipEn = "Easy transport contrast: 'get in/out' for cars/taxis; 'get on/off' for buses, trains, planes, and bikes."
        )
    )
}
