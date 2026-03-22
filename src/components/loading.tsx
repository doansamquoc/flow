import type React from "react";
import { Spinner } from "./ui/spinner";

interface LoadingProps {
  children: React.ReactNode;
}

const Loading = ({ children }: LoadingProps) => {
  return (
    <div className='flex min-h-screen'>
      <div className='m-auto flex flex-col items-center gap-4'>
        <Spinner className='size-18' />
        <span className='text-center text-muted-foreground text-sm'>
          {children}
        </span>
      </div>
    </div>
  );
};

export default Loading;
