package com.example.data

import com.example.model.GrammarPart
import com.example.model.GrammarUnitSummary
import com.example.model.PartAccent

object GrammarBookRepository {

    val parts: List<GrammarPart> = listOf(
        GrammarPart(
            id = "present",
            number = 1,
            titleEn = "Present Tenses",
            titleAr = "أزمنة المضارع",
            unitRange = "Units 1–9",
            descriptionEn = "am/is/are, Present Continuous, Present Simple & have got.",
            descriptionAr = "أفعال الكينونة، المضارع المستمر، المضارع البسيط، والفعل have got.",
            accent = PartAccent.CRIMSON
        ),
        GrammarPart(
            id = "past",
            number = 2,
            titleEn = "Past Tenses",
            titleAr = "أزمنة الماضي",
            unitRange = "Units 10–14",
            descriptionEn = "was/were, Past Simple, Past Continuous & comparisons.",
            descriptionAr = "الماضي من be، الماضي البسيط، الماضي المستمر والفرق بينهما.",
            accent = PartAccent.NAVY
        ),
        GrammarPart(
            id = "present_perfect",
            number = 3,
            titleEn = "Present Perfect",
            titleAr = "المضارع التام",
            unitRange = "Units 15–20",
            descriptionEn = "have/has done, just/already/yet, for/since & vs Past Simple.",
            descriptionAr = "استخدام have/has مع التصريف الثالث، for و since، ومقارنته بالماضي البسيط.",
            accent = PartAccent.EMERALD
        ),
        GrammarPart(
            id = "passive",
            number = 4,
            titleEn = "Passive Voice",
            titleAr = "المبني للمجهول",
            unitRange = "Units 21–22",
            descriptionEn = "is done / was done and is being done / has been done.",
            descriptionAr = "بناء الجملة للمجهول في المضارع والماضي والمستمر والتام.",
            accent = PartAccent.AMBER
        ),
        GrammarPart(
            id = "verb_forms",
            number = 5,
            titleEn = "Verb Forms",
            titleAr = "صيغ الأفعال المساعدة والشاذة",
            unitRange = "Units 23–24",
            descriptionEn = "be/have/do in present & past; regular & irregular verbs.",
            descriptionAr = "تصريفات be و have و do والأفعال المنتظمة والشاذة.",
            accent = PartAccent.CRIMSON
        ),
        GrammarPart(
            id = "future",
            number = 6,
            titleEn = "Future Forms",
            titleAr = "صيغ المستقبل",
            unitRange = "Units 25–28",
            descriptionEn = "Present continuous for future, going to, and will/shall.",
            descriptionAr = "التعبير عن المستقبل بالمضارع المستمر و going to و will.",
            accent = PartAccent.NAVY
        ),
        GrammarPart(
            id = "modals",
            number = 7,
            titleEn = "Modals & Imperatives",
            titleAr = "الأفعال الناقصة والأمر",
            unitRange = "Units 29–36",
            descriptionEn = "might, can/could, must, should, have to, would & used to.",
            descriptionAr = "الاحتمال والاستطاعة والإلزام والنصيحة والعادات القديمة used to.",
            accent = PartAccent.EMERALD
        ),
        GrammarPart(
            id = "there_it",
            number = 8,
            titleEn = "There & It",
            titleAr = "التراكيب There و It",
            unitRange = "Units 37–39",
            descriptionEn = "there is/are, there was/were, there will be & It clauses.",
            descriptionAr = "التعبير عن الوجود there is/are واستخدامات الضمير التمهيدي It.",
            accent = PartAccent.AMBER
        ),
        GrammarPart(
            id = "auxiliaries",
            number = 9,
            titleEn = "Auxiliary Verbs",
            titleAr = "الأفعال المساعدة والردود القصيرة",
            unitRange = "Units 40–43",
            descriptionEn = "Short answers, question tags, so am I / neither do I & negatives.",
            descriptionAr = "الإجابات القصيرة، الأسئلة الذيلية، والموافقة باستخدام so و neither.",
            accent = PartAccent.CRIMSON
        ),
        GrammarPart(
            id = "questions_reported",
            number = 10,
            titleEn = "Questions & Reported Speech",
            titleAr = "الأسئلة والكلام المنقول",
            unitRange = "Units 44–50",
            descriptionEn = "Question word order, subject/object questions, indirect & reported speech.",
            descriptionAr = "تكوين السؤال المباشر وغير المباشر ونقل الكلام.",
            accent = PartAccent.NAVY
        ),
        GrammarPart(
            id = "ing_to",
            number = 11,
            titleEn = "-ing and to...",
            titleAr = "المصدر والصيغة -ing",
            unitRange = "Units 51–54",
            descriptionEn = "Verbs followed by -ing or to..., want you to..., and go -ing.",
            descriptionAr = "متى نستخدم الفعل مضافاً له -ing ومتى نستخدم to + المصدر.",
            accent = PartAccent.EMERALD
        ),
        GrammarPart(
            id = "go_get_do_make",
            number = 12,
            titleEn = "Go, Get, Do, Make, Have",
            titleAr = "الأفعال اليومية الشائعة",
            unitRange = "Units 55–58",
            descriptionEn = "Essential collocations for go, get, do vs make, and have.",
            descriptionAr = "الفرق بين do و make واستخدامات get و go و have.",
            accent = PartAccent.AMBER
        ),
        GrammarPart(
            id = "pronouns",
            number = 13,
            titleEn = "Pronouns & Possessives",
            titleAr = "الضمائر والملكية",
            unitRange = "Units 59–64",
            descriptionEn = "Subject/object pronouns, my/mine, reflexive pronouns & 's.",
            descriptionAr = "ضمائر الفاعل والمفعول، صفات وضمائر الملكية، والضمائر الانعكاسية.",
            accent = PartAccent.CRIMSON
        ),
        GrammarPart(
            id = "articles_nouns",
            number = 14,
            titleEn = "A/An, The & Nouns",
            titleAr = "أدوات التعريف والتنكير والأسماء",
            unitRange = "Units 65–75",
            descriptionEn = "a/an, countable vs uncountable, 'the', place names & this/one.",
            descriptionAr = "قواعد a/an، المعدود وغير المعدود، استخدامات the، وأسماء الأماكن و this/one.",
            accent = PartAccent.NAVY
        ),
        GrammarPart(
            id = "determiners",
            number = 15,
            titleEn = "Determiners & Quantifiers",
            titleAr = "المحددات وأدوات الكمية",
            unitRange = "Units 76–84",
            descriptionEn = "some/any, no/none, somebody/nothing, every/all, both/either & much/many.",
            descriptionAr = "أدوات الكمية والنفي المركب (nobody/nothing) و both/either/neither.",
            accent = PartAccent.EMERALD
        ),
        GrammarPart(
            id = "adjectives_adverbs",
            number = 16,
            titleEn = "Adjectives & Adverbs",
            titleAr = "الصفات والظروف والمقارنة",
            unitRange = "Units 85–92",
            descriptionEn = "Adjectives vs adverbs, comparatives, superlatives, enough & too.",
            descriptionAr = "الفرق بين الصفة والظرف، درجات المقارنة والتفضيل، و enough و too.",
            accent = PartAccent.AMBER
        ),
        GrammarPart(
            id = "word_order_clauses",
            number = 17,
            titleEn = "Word Order, Conjunctions & Conditionals",
            titleAr = "ترتيب الجملة والروابط والشرط",
            unitRange = "Units 93–100",
            descriptionEn = "Word order, still/yet/already, two-object verbs, conjunctions & if-clauses.",
            descriptionAr = "ترتيب الكلمات، still/yet/already، الروابط الزمنية، والجمل الشرطية.",
            accent = PartAccent.CRIMSON
        ),
        GrammarPart(
            id = "relative_clauses",
            number = 18,
            titleEn = "Relative Clauses",
            titleAr = "جمل الوصل",
            unitRange = "Units 101–102",
            descriptionEn = "Defining clauses with who/that/which and omitting the relative pronoun.",
            descriptionAr = "استخدام who و that و which للوصف ومتى يمكن حذف ضمير الوصل.",
            accent = PartAccent.NAVY
        ),
        GrammarPart(
            id = "prepositions_phrasal",
            number = 19,
            titleEn = "Prepositions & Phrasal Verbs",
            titleAr = "حروف الجر والأفعال المركبة",
            unitRange = "Units 103–115",
            descriptionEn = "Time & place (at/on/in), movement, adj/verb prepositions & phrasal verbs.",
            descriptionAr = "حروف جر الزمان والمكان والحركة، حروف الجر مع الصفات والأفعال، والأفعال المركبة.",
            accent = PartAccent.EMERALD
        ),
        GrammarPart(
            id = "appendices",
            number = 20,
            titleEn = "Book Appendices (1–7)",
            titleAr = "ملاحق الكتاب المرجعية (1–7)",
            unitRange = "Appendices 1–7",
            descriptionEn = "Irregular verbs patterns, short forms, spelling rules & phrasal verb reference.",
            descriptionAr = "جداول الأفعال الشاذة، الاختصارات، قواعد الإملاء الكاملة، ومرجع الأفعال المركبة.",
            accent = PartAccent.AMBER
        )
    )

    val allUnits: List<GrammarUnitSummary> by lazy {
        GrammarUnitsPart1.units +
            GrammarUnitsPart2.units +
            GrammarUnitsPart3.units +
            GrammarUnitsPart4.units
    }

    fun getPartById(partId: String): GrammarPart? = parts.find { it.id == partId }

    fun getUnitsForPart(partId: String): List<GrammarUnitSummary> =
        allUnits.filter { it.partId == partId }

    fun getUnitById(unitId: String): GrammarUnitSummary? =
        allUnits.find { it.id == unitId }
}
