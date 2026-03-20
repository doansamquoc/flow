import LoginForm from "@/features/auth/components/login-form";
import Logo from "@/components/logo";
import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/_guest/login")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <div className='min-h-screen mx-auto max-w-md flex flex-col justify-center items-center px-4'>
      <div className='mb-4'>
        <Logo size={48} />
      </div>
      <h1 className='text-center text-lg uppercase mb-6'>
        Chào mừng đến với <span className='font-semibold'>Flow!</span>
      </h1>
      <LoginForm />
      <p className='text-center text-sm text-muted-foreground mt-2'>
        Với việc đăng nhập. Bạn đồng ý với{" "}
        <a href='/terms' className='text-blue-500 hover:underline'>
          điều khoản & điều kiện
        </a>{" "}
        sử dụng dịch vụ.
      </p>
    </div>
  );
}
