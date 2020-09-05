
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Main.vue') }
    ]
  },
  {
    path: '/login',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Login.vue') }
    ]
  },
  {
    path: '/register',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Registration.vue') }
    ]
  },
  {
    path: '/questionnaires',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/QuestionnaireList.vue') }
    ]
  },
  {
    path: '/questionnaires/:id',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/QuestionnairePassing.vue') }
    ]
  },
  {
    path: '/statistics',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Statistics.vue') }
    ]
  },
  {
    path: '/creation',
    component: () => import('../layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/QuestionnaireCreation.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
