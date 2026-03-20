import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_auth/dashboard/create')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div>Hello "/dashboard/create"!</div>
}
